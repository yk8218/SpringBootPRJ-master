package kopo.poly.controller;

import kopo.poly.dto.MelonDTO;
import kopo.poly.service.IMelonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class MelonController {

    @Resource(name = "MelonService")
    private IMelonService melonService;

    /**
     * 멜론 노래 리스트 저장하기
     */
    @GetMapping(value = "melon/collectMelonSong")
    public String collectMelonRank() throws Exception {

        log.info(this.getClass().getName() + ".collectMelonSong Start!");

        // 수집 결과 출력
        String msg;

        int res = melonService.collectMelonSong();

        if (res == 1) {
            msg = "success";

        }else{
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".collectMelonSong End!");

        return msg;
    }

    /**
     * 오늘 수집된 멜론 노래리스트 가져오기
     */
    @GetMapping(value = "melon/getSongList")
    public List<MelonDTO> getSongList() throws Exception {

        log.info(this.getClass().getName() + ".getSongList Start!");

        List<MelonDTO> rList = melonService.getSongList();

        log.info(this.getClass().getName() + ".getSongList End!");

        return rList;
    }

    /**
     * 가수별 수집된 노래의 수 가져오기
     */
    @GetMapping(value = "melon/getSingerSong")
    public List<MelonDTO> getSingerSong() throws Exception {

        log.info(this.getClass().getName() + ".getSingerSong Start!");

        List<MelonDTO> rList = melonService.getSingerSong();

        log.info(this.getClass().getName() + ".getSingerSong End!");

        return rList;
    }
    @GetMapping(value = "melon/collectMelonSongMany")
    public String collectMelonSongMany() throws Exception {
        log.info(this.getClass().getName() + ".collectMelonSongMany Start!");

        String msg;
        int res = melonService.collectMelonSongMany();

        if (res == 1) {
            msg = "succes";

        } else {
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".collectMelonSongMany End!");

        return msg;
    }
    @GetMapping(value = "melon/deleteSong")
    public String deleteSong() throws Exception {

        log.info(this.getClass().getName() + ".deleteSong Start!");
        String msg;
        int res = melonService.deleteSong();
        if (res == 1) {
            msg = "sucess";

        }else {
            msg = "fail";
        }
        log.info(this.getClass().getName() + ".deleteSong End!");
        return msg;
    }
}
