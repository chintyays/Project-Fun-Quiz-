package com.womantalk.client.option;

import com.womantalk.client.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    OptionRepository optionRepository;

    @Override
    public List<Option> findOptionByIdQuestion(Integer idQuestion)
    {
        List<Option> options = optionRepository.findAll();
        List<Option> optionByIdQuestion = new ArrayList<Option>();
        for (Option option : options){
            if(option.getQuestion().getIdQuestion()==idQuestion)
            {
                optionByIdQuestion.add(option);
            }
        }

        return optionByIdQuestion;
    }

    @Override
    public List<Option> findOptionByQuestion(Question question)
    {

        return optionRepository.findAllOptionByQuestion(question.getIdQuestion());
    }

    @Override
    public List<Option> findAllOption() {
        return optionRepository.findAll();
    }

    @Override
    public Integer findValueByIdOption(Integer idOption)
    {
        return optionRepository.getOne(idOption).getValue();
    }

    @Override
    public List<Option> findRightAnswer()
    {
        return optionRepository.findRightAnswer();
    }
}
