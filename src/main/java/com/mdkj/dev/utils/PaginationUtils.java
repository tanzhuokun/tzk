package com.mdkj.dev.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * 描述:分页工具
 *
 * @type_name 类名:PaginationUtils
 */
public class PaginationUtils {


	/**
	 * 1.当前页数 curPage
	 * 2.页数 pageCount
	 * 3.页数显示条数 showSize
	 * 
	 * 1->如果当前所有页数小于等于要展示的页数，则全部显示
	 * 2->如果当前页在起始页内，则保持当前页显示？？？
	 * 3->点击下一页，显示的页数向前推一格
	 * 4->如果是跳转到某页，则显示在中间
	 * 1 2 3 4 5 6 7 
	 *             —
	 * 2 3 4 5 6 7 8          
	 *             —
	 * 5 6 7 8 9 10 11 》跳转页面
	 *       —            
	 *             
	 */

	public static List<Integer> pagination(Integer curPage,int pageCount,int showSize){

		List<Integer> pages=new ArrayList<>();

		if(pageCount<=showSize){//如果总页数小于等于展示的页面数量，则全部展示
			pages=IntStream.range(0, pageCount)
					.mapToObj(i->{return ++i;})
					.collect(Collectors.toList());
		}else if(pageCount-curPage>2){
			
			Integer starPage=curPage-(showSize-2)<=0?1:curPage-(showSize-2);
			Integer endPage=(starPage+showSize>pageCount?pageCount:starPage+showSize);
			pages=IntStream.range(starPage, endPage)
					.mapToObj(i->{return i;})
					.collect(Collectors.toList());
		}else{
			Integer starPage=pageCount-showSize+1;
			Integer endPage=pageCount+1;
			pages=IntStream.range(starPage, endPage)
					.mapToObj(i->{return i;})
					.collect(Collectors.toList());
		}
		
		if(curPage>pageCount){
			pages=IntStream.range(1, showSize+1)
					.mapToObj(i->{return i;})
					.collect(Collectors.toList());
		}
		
		return pages;
	}


	/**
	 * 显示页数
	 * @param pageCount
	 * @return
	 */
	public static List<Integer> pagination(int pageCount){

		List<Integer> pages=pages=IntStream.range(1, pageCount)
					.mapToObj(i->{return i;})
					.collect(Collectors.toList());
		
		return pages;
	}
	
	
}
