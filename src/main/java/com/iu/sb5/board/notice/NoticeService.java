package com.iu.sb5.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.sb5.board.BoardService;
import com.iu.sb5.board.BoardVO;
import com.iu.sb5.util.Pager;

@Service
public class NoticeService implements BoardService{
	@Autowired
	private NoticeMapper noticeMapper;

	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setInsert(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setDelete(boardVO);
	}

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		//pager.setCurPage(1);
		pager.makeRow();
		//전체 글 갯수 구하기 
		long totalCount= noticeMapper.getCount(pager);
		pager.setTotalCount(totalCount);
		//나머지 작업은 Pager에서 해서 넘어오기 
		pager.makePage(totalCount);
		
		return noticeMapper.getList(pager);
	}

	@Override
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.getOne(boardVO);
	}
   
}
