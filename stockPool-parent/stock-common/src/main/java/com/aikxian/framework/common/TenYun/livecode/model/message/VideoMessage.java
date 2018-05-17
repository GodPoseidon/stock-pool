package com.aikxian.framework.common.TenYun.livecode.model.message;

public class VideoMessage extends BaseCallbackData{
	
	/**
	 * 点播用vid，在点播平台可以唯一定位一个点播视频文件
	 */
	private String video_id;
	
	
	/**
	 * 下载地址
	 */
	private String video_url;
	
	/**
	 * 文件大小
	 */
	private String file_size;
	
	
	/**
	 * 	分片开始时间戳  开始时间（unix时间戳，由于I帧干扰，暂时不能精确到秒级）
	 */
	private Integer start_time;
	
	
	/**
	 * 分片结束时间戳   结束时间（unix时间戳，由于I帧干扰，暂时不能精确到秒级）
	 */
	private Integer end_time;
	
	
	/**
	 * 文件id
	 */
	private String file_id;
	
	/**
	 * 	文件格式   flv, hls, mp4
	 */
	private String file_format;
	
	
	/**
	 * 	是否开启点播2.0   	0表示未开启，1表示开启
	 */
	private Integer vod2Flag;
	
	
	/**
	 * 	录制文件id   	点播2.0开启时，才会有这个字段
	 */
	private String record_file_id;
		
	/**
	 * 	推流时长	
	 */
	private Integer duration;
	
	
	/**
	 * 	推流url参数
	 */
	private String stream_param;

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public String getFile_size() {
		return file_size;
	}

	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}

	public Integer getStart_time() {
		return start_time;
	}

	public void setStart_time(Integer start_time) {
		this.start_time = start_time;
	}

	public Integer getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Integer end_time) {
		this.end_time = end_time;
	}

	public String getFile_id() {
		return file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public String getFile_format() {
		return file_format;
	}

	public void setFile_format(String file_format) {
		this.file_format = file_format;
	}

	public Integer getVod2Flag() {
		return vod2Flag;
	}

	public void setVod2Flag(Integer vod2Flag) {
		this.vod2Flag = vod2Flag;
	}

	public String getRecord_file_id() {
		return record_file_id;
	}

	public void setRecord_file_id(String record_file_id) {
		this.record_file_id = record_file_id;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getStream_param() {
		return stream_param;
	}

	public void setStream_param(String stream_param) {
		this.stream_param = stream_param;
	}
	
	

}
