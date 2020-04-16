package com.atguigu.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author:hejr
 * @Description:
 * @Date: 2019/3/25 9:34
 */

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Comment implements Serializable{
    String uid;
    String newsId;
    String post_time;
    String post_loc;
    String comment_context;
    String isNew;
    String rank;
    String parentUid;
    private String 	db_source;

    public static void main(String[] args) {
        Comment comment = new Comment();
    }

}
