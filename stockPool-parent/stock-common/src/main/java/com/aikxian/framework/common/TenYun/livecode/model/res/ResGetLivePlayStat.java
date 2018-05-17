package com.aikxian.framework.common.TenYun.livecode.model.res;

import java.util.Date;
import java.util.List;

import com.aikxian.framework.common.TenYun.livecode.model.BaseResData;

/**
 * 返回播放统计信息以提高查询效率
 * 
 * @author 张晓宇
 *
 */
public class ResGetLivePlayStat extends BaseResData {
	
	private Info output;

	public class Info {

		private Integer stream_count;

		private List<StreamInfo> stream_info;

		private Double total_bandwidth;

		private Integer total_online;
		
		private Date data_time;

		public Integer getStream_count() {
			return stream_count;
		}

		public void setStream_count(Integer stream_count) {
			this.stream_count = stream_count;
		}

		public List<StreamInfo> getStream_info() {
			return stream_info;
		}

		public void setStream_info(List<StreamInfo> stream_info) {
			this.stream_info = stream_info;
		}

		public Double getTotal_bandwidth() {
			return total_bandwidth;
		}

		public void setTotal_bandwidth(Double total_bandwidth) {
			this.total_bandwidth = total_bandwidth;
		}

		public Integer getTotal_online() {
			return total_online;
		}

		public void setTotal_online(Integer total_online) {
			this.total_online = total_online;
		}

		public Date getData_time() {
			return data_time;
		}

		public void setData_time(Date data_time) {
			this.data_time = data_time;
		}

	}



	public Info getOutput() {
		return output;
	}

	public void setOutput(Info output) {
		this.output = output;
	}
}
