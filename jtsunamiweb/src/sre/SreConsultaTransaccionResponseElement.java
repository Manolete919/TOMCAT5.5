/**
 * SreConsultaTransaccionResponseElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sre;

public class SreConsultaTransaccionResponseElement  implements java.io.Serializable {
    private sre.SreConsultaTransaccionResponseElementResult result;

    public SreConsultaTransaccionResponseElement() {
    }

    public SreConsultaTransaccionResponseElement(
           sre.SreConsultaTransaccionResponseElementResult result) {
           this.result = result;
    }


    /**
     * Gets the result value for this SreConsultaTransaccionResponseElement.
     * 
     * @return result
     */
    public sre.SreConsultaTransaccionResponseElementResult getResult() {
        return result;
    }


    /**
     * Sets the result value for this SreConsultaTransaccionResponseElement.
     * 
     * @param result
     */
    public void setResult(sre.SreConsultaTransaccionResponseElementResult result) {
        this.result = result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SreConsultaTransaccionResponseElement)) return false;
        SreConsultaTransaccionResponseElement other = (SreConsultaTransaccionResponseElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.result==null && other.getResult()==null) || 
             (this.result!=null &&
              this.result.equals(other.getResult())));
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
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SreConsultaTransaccionResponseElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicioweb/", ">sreConsultaTransaccionResponseElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicioweb/", "result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicioweb/", ">>sreConsultaTransaccionResponseElement>result"));
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
