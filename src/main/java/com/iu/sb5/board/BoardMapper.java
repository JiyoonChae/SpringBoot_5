package com.iu.sb5.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iu.sb5.board.file.FileVO;
import com.iu.sb5.util.Pager;

public interface BoardMapper {
	
	public long getCount(Pager pager) throws Exception;
	
	public int setInsert(BoardVO boardVO) throws Exception;
	
	public int setInsertFile(FileVO fileVO) throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;
 	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public BoardVO getOne(BoardVO boardVO) throws Exception;
	
}
