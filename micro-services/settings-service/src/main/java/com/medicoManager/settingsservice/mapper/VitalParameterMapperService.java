package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.VitalParameterDto;
import com.medicoManager.settingsservice.model.VitalParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public  class VitalParameterMapperService extends NameEntityMapperService<VitalParameter, VitalParameterDto> {
@Autowired
private BilanMapperService bilanMapperService;
    @Override
    public VitalParameter toEntity(VitalParameterDto dto) {
        VitalParameter vitalParameter= super.toEntity(dto);
        vitalParameter.setValeurMax(dto.getValeurMax());
        vitalParameter.setValeurMin(dto.getValeurMin());
        vitalParameter.setUniteMesure(dto.getUniteMesure());
     //   vitalParameter.setBilans(dto.getBilans().stream().map(bilanDto -> bilanMapperService.toEntity(bilanDto)).collect(Collectors.toList()));
return vitalParameter;    }

    @Override
    public VitalParameterDto toDto(VitalParameter entity) {
        VitalParameterDto vitalParameter= super.toDto(entity);
        vitalParameter.setValeurMax(entity.getValeurMax());
        vitalParameter.setValeurMin(entity.getValeurMin());
        vitalParameter.setUniteMesure(entity.getUniteMesure());    // vitalParameter.setBilans(bilanType.getBilans().stream().map(medicament -> bilanMapperService.toDto(medicament)).collect(Collectors.toList()));
        return vitalParameter;
    //    return super.toDto(vitalParameter);
    }

    @Override
    public VitalParameterDto instanciateDto() {
        return new VitalParameterDto();
    }

    @Override
    public VitalParameter instanciateEntity() {
        return new VitalParameter();
    }

    @Override
    protected Class<VitalParameterDto> getDtoClass() {
        return VitalParameterDto.class;
    }

    @Override
    protected Class<VitalParameter> getEntityClass() {
        return VitalParameter.class;
    }
}
