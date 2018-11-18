package com.mdkj.health.entity.supper;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Material extends BaseEntity{
	
	/**
	 * 素材编号
	 */
	@Column(name="mate_mid",columnDefinition="varchar(24) not null comment '素材编号'")
	private String mid;

	/**
	 * 素材名称
	 */
	@Column(name="mate_title",columnDefinition="varchar(50) not null comment '素材名称'")
	private String mtitle;

	/**
	 * 素材图片
	 */
	@Column(name="mate_cover",columnDefinition="varchar(200) comment '素材封面'")
	private String mcover;

	/**
	 * 素材作者
	 */
	@Column(name="mate_author",columnDefinition="varchar(100) comment '发布人'")
	private String author;
	
	/**
	 * 素材来源
	 */
	@Column(name="mate_origin",columnDefinition="varchar(200) comment '素材来源'")
	private String origin;

	/**
	 * 素材摘要
	 */
	@Column(name="mate_digest",columnDefinition="varchar(250) comment '素材描述'")
	private String digest;

	/**
	 * 素材内容
	 */
	@Column(name="mate_content",columnDefinition="longtext comment '素材内容'")
	private String mcontent;
	
	/**
	 * 文章预览连接
	 */
	@Column(name="mate_url",columnDefinition="varchar(200) not null comment '素材链接'")
	private String url;

	/**
	 * 素材类别
	 * 参数
	 * 0:知识类
	 * 1:微信类
	 */
	@Column(name="mate_type",columnDefinition="int(2) not null default 0 comment '素材类型:0、知识类；1、微信类'")
	private int type;
	
	/**
	 * 是否审核
	 */
	@Column(name="mate_verify",columnDefinition="int(2) not null default 0 comment '是否审核:0、未审核；1、已审核'")
	private int verify;
	
	/**
	 * 评论量
	 */
	@Column(name="mate_comment",columnDefinition="int(11) not null default 0 comment '素材评论量'")
	private int comment;
	
	/**
	 * 点击量
	 */
	@Column(name="mate_read",columnDefinition="int(11) not null default 0 comment '素材点击量'")
	private int read;
	
	/**
	 * 赞数量
	 */
	@Column(name="mate_praise",columnDefinition="int(11) not null default 0 comment '素材赞量'")
	private int praise;
	

	@Column(name="mate_order",columnDefinition="int(11) not null default 0")
	private int order;//排序
	
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getMcover() {
		return mcover;
	}

	public void setMcover(String mcover) {
		this.mcover = mcover;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	
	
}
