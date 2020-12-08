package com.iu.sb5.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.sb5.board.BoardService;
import com.iu.sb5.board.BoardVO;
import com.iu.sb5.board.file.FileVO;
import com.iu.sb5.util.FileManager;
import com.iu.sb5.util.FilePathGenerator;
import com.iu.sb5.util.Pager;

import lombok.val;

@Service
public class QnaService implements BoardService{
	@Autowired
	private QnaMapper qnaMapper;
	
	//파일 저장 디렉토리 생성
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileManager fileManager;
	
	@Value("${board.qna.filePath}")
	private String filePath;
	
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		int result = qnaMapper.setInsert(boardVO);
		String filePath="upload/qna";
		File file = filePathGenerator.getUseResourceLoader(filePath);
		
		for(MultipartFile multipartfile: files) {
			if(multipartfile.getSize()==0) {
				continue;
			}
			
			String fileName= fileManager.saveFileCopy(multipartfile, file);
			System.out.println(fileName);
			FileVO fileVO = new FileVO();
			fileVO.setFileName(fileName);
			fileVO.setOriName(multipartfile.getOriginalFilename());
			fileVO.setNum(boardVO.getNum());
			
			result = qnaMapper.setInsertFile(fileVO);
		}
		
		return result;
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
