/**
 * TestConnectionElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package eis;

public class TestConnectionElement  implements java.io.Serializable {
    private java.lang.String dsId;

    public TestConnectionElement() {
    }

    public TestConnectionElement(
           java.lang.String dsId) {
           this.dsId = dsId;
    }


    /**
     * Gets the dsId value for this TestConnectionElement.
     * 
     * @return dsId
     */
    public java.lang.String getDsId() {
        return dsId;
    }


    /**
     * Sets the dsId value for this TestConnectionElement.
     * 
     * @param dsId
     */
    public void setDsId(java.lang.String dsId) {
        this.dsId = dsId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TestConnectionElement)) return false;
        TestConnectionElement other = (TestConnectionElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsId==null && other.getDsId()==null) || 
             (this.dsId!=null &&
              this.dsId.equals(other.getDsId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDsId() != null) {
            _hashCode += getDsId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TestConnectionElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", ">testConnectionElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "dsId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
