/**
 * EipConsumeServicio_Out.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package eis;

public class EipConsumeServicio_Out  implements java.io.Serializable {
    private int pnerrorOut;

    private java.lang.String pvresultadoOut;

    private java.lang.String pverrorOut;

    public EipConsumeServicio_Out() {
    }

    public EipConsumeServicio_Out(
           int pnerrorOut,
           java.lang.String pvresultadoOut,
           java.lang.String pverrorOut) {
           this.pnerrorOut = pnerrorOut;
           this.pvresultadoOut = pvresultadoOut;
           this.pverrorOut = pverrorOut;
    }


    /**
     * Gets the pnerrorOut value for this EipConsumeServicio_Out.
     * 
     * @return pnerrorOut
     */
    public int getPnerrorOut() {
        return pnerrorOut;
    }


    /**
     * Sets the pnerrorOut value for this EipConsumeServicio_Out.
     * 
     * @param pnerrorOut
     */
    public void setPnerrorOut(int pnerrorOut) {
        this.pnerrorOut = pnerrorOut;
    }


    /**
     * Gets the pvresultadoOut value for this EipConsumeServicio_Out.
     * 
     * @return pvresultadoOut
     */
    public java.lang.String getPvresultadoOut() {
        return pvresultadoOut;
    }


    /**
     * Sets the pvresultadoOut value for this EipConsumeServicio_Out.
     * 
     * @param pvresultadoOut
     */
    public void setPvresultadoOut(java.lang.String pvresultadoOut) {
        this.pvresultadoOut = pvresultadoOut;
    }


    /**
     * Gets the pverrorOut value for this EipConsumeServicio_Out.
     * 
     * @return pverrorOut
     */
    public java.lang.String getPverrorOut() {
        return pverrorOut;
    }


    /**
     * Sets the pverrorOut value for this EipConsumeServicio_Out.
     * 
     * @param pverrorOut
     */
    public void setPverrorOut(java.lang.String pverrorOut) {
        this.pverrorOut = pverrorOut;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EipConsumeServicio_Out)) return false;
        EipConsumeServicio_Out other = (EipConsumeServicio_Out) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.pnerrorOut == other.getPnerrorOut() &&
            ((this.pvresultadoOut==null && other.getPvresultadoOut()==null) || 
             (this.pvresultadoOut!=null &&
              this.pvresultadoOut.equals(other.getPvresultadoOut()))) &&
            ((this.pverrorOut==null && other.getPverrorOut()==null) || 
             (this.pverrorOut!=null &&
              this.pverrorOut.equals(other.getPverrorOut())));
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
        _hashCode += getPnerrorOut();
        if (getPvresultadoOut() != null) {
            _hashCode += getPvresultadoOut().hashCode();
        }
        if (getPverrorOut() != null) {
            _hashCode += getPverrorOut().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EipConsumeServicio_Out.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "EipConsumeServicio_Out"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pnerrorOut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "pnerrorOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pvresultadoOut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "pvresultadoOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pverrorOut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "pverrorOut"));
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
