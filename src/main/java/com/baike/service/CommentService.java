package com.baike.service;

import com.baike.model.Comment;

import java.util.List;

/**
 * Created by xiechur on 2017/1/4/004.
 */
public interface CommentService {

    public int addComment(Comment comment);

    public int deleteComment(int id);

    public List<Comment> getCommentList(int entryId);

    public Comment getComment(int commentId);
}
