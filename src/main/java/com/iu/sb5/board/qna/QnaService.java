package com.iu.sb5.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.sb5.board.BoardService;
import com.iu.sb5.board.BoardVO;
import com.iu.sb5.util.Pager;

@Service
public class QnaService implements BoardService{
	@Autowired
	private QnaMapper qnaMapper;
	
	@Override
	public int setInsert(BoardVO boardVO) throws Exception {
		
		return qnaMapper.setInsert(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		System.out.println("qna update service 까지옴");
		return qnaMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.setDelete(boardVO);
	}

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		System.out.println("2:"+pager.getCurPage());
		pager.makeRow();
		
		long totalCount = qnaMapper.getCount(pager);
		pager.setTotalCount(totalCount);
		pager.makePage(totalCount);
		
		return qnaMapper.getList(pager);
	}

	@Override
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		
		return qnaMapper.getOne(boardVO);
	}
	
}
