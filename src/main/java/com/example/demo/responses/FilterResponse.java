package com.example.demo.responses;

import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterResponse implements Serializable {

        private List<?> data;

        private Map<String, String> meta = new HashMap<>(1);

        public FilterResponse(List<?> data, String message) {
            this.setData(data);
            setMetaMessage(message);
        }

        private void setMetaMessage(String msg) {
            this.meta.put("message", msg);
        }

		public List<?> getData() {
			return data;
		}

		public void setData(List<?> data) {
			this.data = data;
		}

		public Map<String, String> getMeta() {
			return meta;
		}

		public void setMeta(Map<String, String> meta) {
			this.meta = meta;
		}
}
