package com.vote.vote.controller;

import java.util.List;

import com.vote.vote.db.dto.Reply;
import com.vote.vote.repository.ReplyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReplyController {
 
    @Autowired 
    ReplyRepository replyRepository;

    @GetMapping("/list")
    public List<Reply> replylist(Model model){

        return replyRepository.findAll();

    }
  
    
}


