package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.DispositifMedicalDto;
import com.medicoManager.settingsservice.dto.MatierePremiereDto;
import com.medicoManager.settingsservice.model.DispositifMedical;
import com.medicoManager.settingsservice.model.MatierePremiere;
import org.springframework.stereotype.Service;

@Service
public  class MatierePremiereMapperService extends NameEntityMapperService<MatierePremiere, MatierePremiereDto> {
    @Override
    public MatierePremiere toEntity(MatierePremiereDto dto) {
        MatierePremiere m= super.toEntity(dto);
        m.setUnite_mesure(dto.getUnite_mesure());
        m.setPrix_achat(dto.getPrix_achat());
 //       m.setPrix_location(dto.getPrix_location());
      //  m.setDescription(dto.getDescription());

        return m;
    }

    @Override
    public MatierePremiereDto toDto(MatierePremiere entity) {
        MatierePremiereDto m= super.toDto(entity);
 //= super.toEntity(dto);
        m.setUnite_mesure(entity.getUnite_mesure());
        m.setPrix_achat(entity.getPrix_achat());
     //   m.setPrix_location(entity.getPrix_location());
       // m.setDescription(entity.getDescription());
      //  m.setFabricant(entity.getFabricant());
        return m;
    }

    @Override
    public MatierePremiereDto instanciateDto() {
        return new MatierePremiereDto();
    }

    @Override
    public MatierePremiere instanciateEntity() {
        return new MatierePremiere();
    }

    @Override
    protected Class<MatierePremiereDto> getDtoClass() {
        return MatierePremiereDto.class;
    }

    @Override
    protected Class<MatierePremiere> getEntityClass() {
        return MatierePremiere.class;
    }
}
