package com.baike.service.imp;

import com.baike.dao.CommentMapper;
import com.baike.model.Comment;
import com.baike.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiechur on 2017/1/4/004.
 */
@Service
public class CommentServiceImpl implements CommentService{


    @Resource
    private CommentMapper commentMapper;

    public int addComment(Comment comment) {
        return commentMapper.insertSelective(comment);
    }

    public int deleteComment(int id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    public List<Comment> getCommentList(int entryId) {
        return commentMapper.getCommentList(entryId);
    }

    public Comment getComment(int commentId) {
        return commentMapper.selectByPrimaryKey(commentId);
    }


}

