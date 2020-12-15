package com.iu.sb5.board.notice;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException.NotImplemented;
import org.springframework.web.multipart.MultipartFile;

import com.iu.sb5.board.BoardService;
import com.iu.sb5.board.BoardVO;
import com.iu.sb5.board.file.FileVO;
import com.iu.sb5.util.FileManager;
import com.iu.sb5.util.FilePathGenerator;
import com.iu.sb5.util.Pager;

@Service
public class NoticeService implements BoardService{
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Value("${board.notice.filePath}")
	private String filePath;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		int result = noticeMapper.setInsert(boardVO);
		File file = filePathGenerator.getUseResourceLoader(filePath);
		System.out.println(file);
		for(MultipartFile multipartfile: files) {
			if(multipartfile.getSize() ==0) {
				continue;
			}
			String fileName= fileManager.saveFileCopy(multipartfile, file);
			FileVO fileVO = new FileVO();
			fileVO.setFileName(fileName);
			fileVO.setOriName(multipartfile.getOriginalFilename());
			fileVO.setNum(boardVO.getNum());
			result = noticeMapper.setInsertFile(fileVO);
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO, MultipartFile[] files) throws Exception {
		
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
	
	public List<FileVO> getFiles(BoardVO boardVO) throws Exception{
		System.out.println("서비스 번호: "+ boardVO.getNum());
		return noticeMapper.getFiles(boardVO);
	}
   
}
