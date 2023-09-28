package rungropp.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rungropp.web.dto.ClubDto;
import rungropp.web.models.Club;
import rungropp.web.repository.ClubRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImp implements ClubService {

    private final ClubRepository clubRepository;


    @Autowired
    public ClubServiceImp(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((this::mapToClubDto)).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto(Club club){
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updateOn(club.getUpdateOn())
                .build();
    }
}
