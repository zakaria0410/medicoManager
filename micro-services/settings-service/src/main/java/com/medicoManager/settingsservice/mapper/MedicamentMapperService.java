package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.AbstractNameSettingsDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.model.AbstractNameSettings;
import com.medicoManager.settingsservice.model.Medicament;
import org.springframework.stereotype.Service;

@Service
public  class MedicamentMapperService extends NameEntityMapperService<Medicament, MedicamentDto> {
    @Override
    public Medicament toEntity(MedicamentDto dto) {
        Medicament m= super.toEntity(dto);
        m.setContreIndication(dto.getContreIndication());
        m.setDosage(dto.getDosage());
        m.setPrix(dto.getPrix());
      //  m.setDescription(dto.getDescription());
        m.setFabricant(dto.getFabricant());
        return m;
    }

    @Override
    public MedicamentDto toDto(Medicament entity) {
        MedicamentDto m= super.toDto(entity);
 //= super.toEntity(dto);
        m.setContreIndication(entity.getContreIndication());
        m.setDosage(entity.getDosage());
        m.setPrix(entity.getPrix());
       // m.setDescription(entity.getDescription());
        m.setFabricant(entity.getFabricant());
        return m;
    }

    @Override
    protected MedicamentDto instanciateDto() {
        return new MedicamentDto();
    }

    @Override
    protected Medicament instanciateEntity() {
        return new Medicament();
    }

    @Override
    protected Class<MedicamentDto> getDtoClass() {
        return MedicamentDto.class;
    }

    @Override
    protected Class<Medicament> getEntityClass() {
        return Medicament.class;
    }
}
