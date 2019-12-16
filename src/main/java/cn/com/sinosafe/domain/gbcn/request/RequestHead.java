package cn.com.sinosafe.domain.gbcn.request;

import javax.xml.bind.annotation.XmlType;


@XmlType(name = "requestHead",propOrder = {"requestUUID","sign"})
public class RequestHead {

        private String requestUUID;
        private String sign;
        public String getRequestUUID() {
            return requestUUID;
        }
        public void setRequestUUID(String requestUUID) {
            this.requestUUID = requestUUID;
        }
        public String getSign() {
            return sign;
        }
        public void setSign(String sign) {
            this.sign = sign;
        }
        public RequestHead() {
        }
        public RequestHead(String requestUUID,String sign) {
            this.requestUUID = requestUUID;
            this.sign = sign;
        }
}
