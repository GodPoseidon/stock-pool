package com.aikxian.framework.common.TenYun.livecode.model.res;

import java.util.List;

import com.aikxian.framework.common.TenYun.livecode.model.BaseResData;

public class ResGetLivePushStatHistory extends BaseResData {

	private List<StreamInfo> output;

	public List<StreamInfo> getOutput() {
		return output;
	}

	public void setOutput(List<StreamInfo> output) {
		this.output = output;
	}

	class StreamInfo {

		private String time;

		private String client_ip;

		private String server_ip;

		private Integer fps;

		private Integer speed;

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getClient_ip() {
			return client_ip;
		}

		public void setClient_ip(String client_ip) {
			this.client_ip = client_ip;
		}

		public String getServer_ip() {
			return server_ip;
		}

		public void setServer_ip(String server_ip) {
			this.server_ip = server_ip;
		}

		public Integer getFps() {
			return fps;
		}

		public void setFps(Integer fps) {
			this.fps = fps;
		}

		public Integer getSpeed() {
			return speed;
		}

		public void setSpeed(Integer speed) {
			this.speed = speed;
		}

	}

}
