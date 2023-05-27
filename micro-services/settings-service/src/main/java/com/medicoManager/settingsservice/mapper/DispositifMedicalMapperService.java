package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.DispositifMedicalDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.model.DispositifMedical;
import com.medicoManager.settingsservice.model.Medicament;
import org.springframework.stereotype.Service;

@Service
public  class DispositifMedicalMapperService extends NameEntityMapperService<DispositifMedical, DispositifMedicalDto> {
    @Override
    public DispositifMedical toEntity(DispositifMedicalDto dto) {
        DispositifMedical m= super.toEntity(dto);
        m.setUnite_mesure(dto.getUnite_mesure());
        m.setPrix_achat(dto.getPrix_achat());
        m.setPrix_location(dto.getPrix_location());
      //  m.setDescription(dto.getDescription());

        return m;
    }

    @Override
    public DispositifMedicalDto toDto(DispositifMedical entity) {
        DispositifMedicalDto m= super.toDto(entity);
 //= super.toEntity(dto);
        m.setUnite_mesure(entity.getUnite_mesure());
        m.setPrix_achat(entity.getPrix_achat());
        m.setPrix_location(entity.getPrix_location());
       // m.setDescription(entity.getDescription());
      //  m.setFabricant(entity.getFabricant());
        return m;
    }

    @Override
    public DispositifMedicalDto instanciateDto() {
        return new DispositifMedicalDto();
    }

    @Override
    public DispositifMedical instanciateEntity() {
        return new DispositifMedical();
    }

    @Override
    protected Class<DispositifMedicalDto> getDtoClass() {
        return DispositifMedicalDto.class;
    }

    @Override
    protected Class<DispositifMedical> getEntityClass() {
        return DispositifMedical.class;
    }
}
