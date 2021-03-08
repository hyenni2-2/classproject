package com.mw.closet.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import lombok.Data;


// tbl_closet DB 정보
@Data
public class Closet {

	private String src;
	private int x;
	private int y;
	private String z;

}
