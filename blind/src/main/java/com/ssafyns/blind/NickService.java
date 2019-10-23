package com.ssafyns.blind;

import com.ssafyns.blind.model.Nick;
import com.ssafyns.blind.repo.NickRepsitory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class NickService {
    private NickRepsitory nickRepsitory;

    @Transactional
    public void getNickName() {
        List<Nick> nickDataList = new ArrayList<>();
        try{
            //파일 객체 생성
            File file = new File("C:\\Users\\multicampus\\Desktop\\MyBlind\\blind\\src\\main\\result.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
//                System.out.println(line);
                nickDataList.add(new Nick(line));

            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }

        nickRepsitory.saveAll(nickDataList);

    }

    public NickService(NickRepsitory nickRepsitory){
        this.nickRepsitory = nickRepsitory;
    }
}
