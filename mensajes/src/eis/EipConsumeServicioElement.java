/**
 * EipConsumeServicioElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package eis;

public class EipConsumeServicioElement  implements java.io.Serializable {
    private java.lang.String dsId;

    private java.math.BigDecimal pnIdServicioInformacion;

    private java.lang.String pvParametroBind1;

    private java.lang.String pvParametroBind2;

    private java.lang.String pvParametroBind3;

    private java.lang.String pvParametroBind4;

    private java.lang.String pvParametroBind5;

    public EipConsumeServicioElement() {
    }

    public EipConsumeServicioElement(
           java.lang.String dsId,
           java.math.BigDecimal pnIdServicioInformacion,
           java.lang.String pvParametroBind1,
           java.lang.String pvParametroBind2,
           java.lang.String pvParametroBind3,
           java.lang.String pvParametroBind4,
           java.lang.String pvParametroBind5) {
           this.dsId = dsId;
           this.pnIdServicioInformacion = pnIdServicioInformacion;
           this.pvParametroBind1 = pvParametroBind1;
           this.pvParametroBind2 = pvParametroBind2;
           this.pvParametroBind3 = pvParametroBind3;
           this.pvParametroBind4 = pvParametroBind4;
           this.pvParametroBind5 = pvParametroBind5;
    }


    /**
     * Gets the dsId value for this EipConsumeServicioElement.
     * 
     * @return dsId
     */
    public java.lang.String getDsId() {
        return dsId;
    }


    /**
     * Sets the dsId value for this EipConsumeServicioElement.
     * 
     * @param dsId
     */
    public void setDsId(java.lang.String dsId) {
        this.dsId = dsId;
    }


    /**
     * Gets the pnIdServicioInformacion value for this EipConsumeServicioElement.
     * 
     * @return pnIdServicioInformacion
     */
    public java.math.BigDecimal getPnIdServicioInformacion() {
        return pnIdServicioInformacion;
    }


    /**
     * Sets the pnIdServicioInformacion value for this EipConsumeServicioElement.
     * 
     * @param pnIdServicioInformacion
     */
    public void setPnIdServicioInformacion(java.math.BigDecimal pnIdServicioInformacion) {
        this.pnIdServicioInformacion = pnIdServicioInformacion;
    }


    /**
     * Gets the pvParametroBind1 value for this EipConsumeServicioElement.
     * 
     * @return pvParametroBind1
     */
    public java.lang.String getPvParametroBind1() {
        return pvParametroBind1;
    }


    /**
     * Sets the pvParametroBind1 value for this EipConsumeServicioElement.
     * 
     * @param pvParametroBind1
     */
    public void setPvParametroBind1(java.lang.String pvParametroBind1) {
        this.pvParametroBind1 = pvParametroBind1;
    }


    /**
     * Gets the pvParametroBind2 value for this EipConsumeServicioElement.
     * 
     * @return pvParametroBind2
     */
    public java.lang.String getPvParametroBind2() {
        return pvParametroBind2;
    }


    /**
     * Sets the pvParametroBind2 value for this EipConsumeServicioElement.
     * 
     * @param pvParametroBind2
     */
    public void setPvParametroBind2(java.lang.String pvParametroBind2) {
        this.pvParametroBind2 = pvParametroBind2;
    }


    /**
     * Gets the pvParametroBind3 value for this EipConsumeServicioElement.
     * 
     * @return pvParametroBind3
     */
    public java.lang.String getPvParametroBind3() {
        return pvParametroBind3;
    }


    /**
     * Sets the pvParametroBind3 value for this EipConsumeServicioElement.
     * 
     * @param pvParametroBind3
     */
    public void setPvParametroBind3(java.lang.String pvParametroBind3) {
        this.pvParametroBind3 = pvParametroBind3;
    }


    /**
     * Gets the pvParametroBind4 value for this EipConsumeServicioElement.
     * 
     * @return pvParametroBind4
     */
    public java.lang.String getPvParametroBind4() {
        return pvParametroBind4;
    }


    /**
     * Sets the pvParametroBind4 value for this EipConsumeServicioElement.
     * 
     * @param pvParametroBind4
     */
    public void setPvParametroBind4(java.lang.String pvParametroBind4) {
        this.pvParametroBind4 = pvParametroBind4;
    }


    /**
     * Gets the pvParametroBind5 value for this EipConsumeServicioElement.
     * 
     * @return pvParametroBind5
     */
    public java.lang.String getPvParametroBind5() {
        return pvParametroBind5;
    }


    /**
     * Sets the pvParametroBind5 value for this EipConsumeServicioElement.
     * 
     * @param pvParametroBind5
     */
    public void setPvParametroBind5(java.lang.String pvParametroBind5) {
        this.pvParametroBind5 = pvParametroBind5;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EipConsumeServicioElement)) return false;
        EipConsumeServicioElement other = (EipConsumeServicioElement) obj;
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
              this.dsId.equals(other.getDsId()))) &&
            ((this.pnIdServicioInformacion==null && other.getPnIdServicioInformacion()==null) || 
             (this.pnIdServicioInformacion!=null &&
              this.pnIdServicioInformacion.equals(other.getPnIdServicioInformacion()))) &&
            ((this.pvParametroBind1==null && other.getPvParametroBind1()==null) || 
             (this.pvParametroBind1!=null &&
              this.pvParametroBind1.equals(other.getPvParametroBind1()))) &&
            ((this.pvParametroBind2==null && other.getPvParametroBind2()==null) || 
             (this.pvParametroBind2!=null &&
              this.pvParametroBind2.equals(other.getPvParametroBind2()))) &&
            ((this.pvParametroBind3==null && other.getPvParametroBind3()==null) || 
             (this.pvParametroBind3!=null &&
              this.pvParametroBind3.equals(other.getPvParametroBind3()))) &&
            ((this.pvParametroBind4==null && other.getPvParametroBind4()==null) || 
             (this.pvParametroBind4!=null &&
              this.pvParametroBind4.equals(other.getPvParametroBind4()))) &&
            ((this.pvParametroBind5==null && other.getPvParametroBind5()==null) || 
             (this.pvParametroBind5!=null &&
              this.pvParametroBind5.equals(other.getPvParametroBind5())));
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
        if (getPnIdServicioInformacion() != null) {
            _hashCode += getPnIdServicioInformacion().hashCode();
        }
        if (getPvParametroBind1() != null) {
            _hashCode += getPvParametroBind1().hashCode();
        }
        if (getPvParametroBind2() != null) {
            _hashCode += getPvParametroBind2().hashCode();
        }
        if (getPvParametroBind3() != null) {
            _hashCode += getPvParametroBind3().hashCode();
        }
        if (getPvParametroBind4() != null) {
            _hashCode += getPvParametroBind4().hashCode();
        }
        if (getPvParametroBind5() != null) {
            _hashCode += getPvParametroBind5().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EipConsumeServicioElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", ">eipConsumeServicioElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "dsId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pnIdServicioInformacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "pnIdServicioInformacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pvParametroBind1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "pvParametroBind1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pvParametroBind2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "pvParametroBind2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pvParametroBind3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "pvParametroBind3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pvParametroBind4");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "pvParametroBind4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pvParametroBind5");
        elemField.setXmlName(new javax.xml.namespace.QName("http://axis/EISApiOnlineWS.wsdl/types/", "pvParametroBind5"));
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
