package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.mapper.BilanNumeriqueMapperService;
import com.medicoManager.settingsservice.mapper.BilanTextuelMapperService;
import com.medicoManager.settingsservice.model.Bilan;
import com.medicoManager.settingsservice.model.BilanNumerique;
import com.medicoManager.settingsservice.model.BilanTextuel;
import com.medicoManager.settingsservice.model.Medicament;
import com.medicoManager.settingsservice.repository.BilanRepository;
import com.medicoManager.settingsservice.repository.GenericSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BilanService extends AbstractNameSettingsService<Bilan, BilanDto> {
    @Autowired
    private BilanNumeriqueService bilanNumeriqueService;
    @Autowired
    private BilanTextuelService bilanTextuelService;
    @Autowired
    private BilanRepository bilanRepository;

    @Override
    protected Class<BilanDto> getDtoClass() {
        return BilanDto.class;
    }

    @Override
    protected Class<Bilan> getEntityClass() {
        return Bilan.class;
    }

    @Override
    public List<BilanDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<BilanDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
@Autowired
private GenericSearchRepository genericSearchRepository;
    @Autowired
    private BilanRepository repository;
    @Override
    public List<BilanDto> search(HashMap<String, Object> mapSearch) {
        List<Bilan> entities=repository.findAll();
        for (String s:mapSearch.keySet()){
            if(mapSearch.get(s)!=null ){

                List<Bilan> searchs=genericSearchRepository.executeDynamicQueryForString(Bilan.class,s,mapSearch.get(s)).stream().collect(Collectors.toList());
                entities=entities.stream().filter(d -> searchs.contains(d)).collect(Collectors.toList());;
            }
        }
    return entities.stream().map(bilan->{
            BilanDto bilanDto=new BilanDto();
            if(bilan instanceof BilanTextuel) return bilanTextuelService.getById(bilan.getId());
            else if(bilan instanceof BilanNumerique) return bilanNumeriqueService.getById(bilan.getId());
            else return null;
    }).filter(bilanDto -> bilanDto!=null).collect(Collectors.toList());}

    @Override
    public BilanDto create(BilanDto dto) {
        if(dto.getNumerique())return bilanNumeriqueService.create(dto);
        else return bilanTextuelService.create(dto);
    }

    @Override
    public List<BilanDto> saveAll(List<BilanDto> dtos) {
        dtos.stream().forEach(
                bilanDto -> {
                    if(bilanDto.getNumerique())bilanNumeriqueService.create(bilanDto);
                    else bilanTextuelService.create(bilanDto);
                }
        );
    return dtos;}

    @Override
    public BilanDto update(BilanDto dto) {
      if(dto.getNumerique())return bilanNumeriqueService.update(dto);
      else return bilanTextuelService.update(dto);
    }

    @Override
    public BilanDto getById(Long id) {
   Bilan bilan=bilanRepository.findById(id).orElse(null);
   if(bilan!=null){
       if(bilan instanceof BilanTextuel)return bilanTextuelService.getById(id);
       else if(bilan instanceof BilanTextuel) return bilanNumeriqueService.getById(id);
       else return null;
   }
    else return null;}

    @Override
    public List<BilanDto> getAll() {
        return bilanRepository.findAll().stream().map(bilan -> {
             if(bilan instanceof BilanNumerique)return bilanNumeriqueService.getById(bilan.getId());
             else  if(bilan instanceof BilanTextuel) return bilanTextuelService.getById(bilan.getId());
             else return null;
         }).filter(bilanDto -> bilanDto!=null).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

