/**
 * SreReceptaTransaccionElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sre;

public class SreReceptaTransaccionElement  implements java.io.Serializable {
    private java.lang.String id_Instancia;

    private java.lang.String id_Tipo_Transaccion;

    private java.lang.String id_Integrador;

    private java.lang.String cod_Alterno_Distribuidor;

    private java.lang.String usuario;

    private java.lang.String clave;

    private java.lang.String data_Source;

    private sre.SreReceptaTransaccionElementParametros_Transaccion parametros_Transaccion;

    public SreReceptaTransaccionElement() {
    }

    public SreReceptaTransaccionElement(
           java.lang.String id_Instancia,
           java.lang.String id_Tipo_Transaccion,
           java.lang.String id_Integrador,
           java.lang.String cod_Alterno_Distribuidor,
           java.lang.String usuario,
           java.lang.String clave,
           java.lang.String data_Source,
           sre.SreReceptaTransaccionElementParametros_Transaccion parametros_Transaccion) {
           this.id_Instancia = id_Instancia;
           this.id_Tipo_Transaccion = id_Tipo_Transaccion;
           this.id_Integrador = id_Integrador;
           this.cod_Alterno_Distribuidor = cod_Alterno_Distribuidor;
           this.usuario = usuario;
           this.clave = clave;
           this.data_Source = data_Source;
           this.parametros_Transaccion = parametros_Transaccion;
    }


    /**
     * Gets the id_Instancia value for this SreReceptaTransaccionElement.
     * 
     * @return id_Instancia
     */
    public java.lang.String getId_Instancia() {
        return id_Instancia;
    }


    /**
     * Sets the id_Instancia value for this SreReceptaTransaccionElement.
     * 
     * @param id_Instancia
     */
    public void setId_Instancia(java.lang.String id_Instancia) {
        this.id_Instancia = id_Instancia;
    }


    /**
     * Gets the id_Tipo_Transaccion value for this SreReceptaTransaccionElement.
     * 
     * @return id_Tipo_Transaccion
     */
    public java.lang.String getId_Tipo_Transaccion() {
        return id_Tipo_Transaccion;
    }


    /**
     * Sets the id_Tipo_Transaccion value for this SreReceptaTransaccionElement.
     * 
     * @param id_Tipo_Transaccion
     */
    public void setId_Tipo_Transaccion(java.lang.String id_Tipo_Transaccion) {
        this.id_Tipo_Transaccion = id_Tipo_Transaccion;
    }


    /**
     * Gets the id_Integrador value for this SreReceptaTransaccionElement.
     * 
     * @return id_Integrador
     */
    public java.lang.String getId_Integrador() {
        return id_Integrador;
    }


    /**
     * Sets the id_Integrador value for this SreReceptaTransaccionElement.
     * 
     * @param id_Integrador
     */
    public void setId_Integrador(java.lang.String id_Integrador) {
        this.id_Integrador = id_Integrador;
    }


    /**
     * Gets the cod_Alterno_Distribuidor value for this SreReceptaTransaccionElement.
     * 
     * @return cod_Alterno_Distribuidor
     */
    public java.lang.String getCod_Alterno_Distribuidor() {
        return cod_Alterno_Distribuidor;
    }


    /**
     * Sets the cod_Alterno_Distribuidor value for this SreReceptaTransaccionElement.
     * 
     * @param cod_Alterno_Distribuidor
     */
    public void setCod_Alterno_Distribuidor(java.lang.String cod_Alterno_Distribuidor) {
        this.cod_Alterno_Distribuidor = cod_Alterno_Distribuidor;
    }


    /**
     * Gets the usuario value for this SreReceptaTransaccionElement.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this SreReceptaTransaccionElement.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the clave value for this SreReceptaTransaccionElement.
     * 
     * @return clave
     */
    public java.lang.String getClave() {
        return clave;
    }


    /**
     * Sets the clave value for this SreReceptaTransaccionElement.
     * 
     * @param clave
     */
    public void setClave(java.lang.String clave) {
        this.clave = clave;
    }


    /**
     * Gets the data_Source value for this SreReceptaTransaccionElement.
     * 
     * @return data_Source
     */
    public java.lang.String getData_Source() {
        return data_Source;
    }


    /**
     * Sets the data_Source value for this SreReceptaTransaccionElement.
     * 
     * @param data_Source
     */
    public void setData_Source(java.lang.String data_Source) {
        this.data_Source = data_Source;
    }


    /**
     * Gets the parametros_Transaccion value for this SreReceptaTransaccionElement.
     * 
     * @return parametros_Transaccion
     */
    public sre.SreReceptaTransaccionElementParametros_Transaccion getParametros_Transaccion() {
        return parametros_Transaccion;
    }


    /**
     * Sets the parametros_Transaccion value for this SreReceptaTransaccionElement.
     * 
     * @param parametros_Transaccion
     */
    public void setParametros_Transaccion(sre.SreReceptaTransaccionElementParametros_Transaccion parametros_Transaccion) {
        this.parametros_Transaccion = parametros_Transaccion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SreReceptaTransaccionElement)) return false;
        SreReceptaTransaccionElement other = (SreReceptaTransaccionElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id_Instancia==null && other.getId_Instancia()==null) || 
             (this.id_Instancia!=null &&
              this.id_Instancia.equals(other.getId_Instancia()))) &&
            ((this.id_Tipo_Transaccion==null && other.getId_Tipo_Transaccion()==null) || 
             (this.id_Tipo_Transaccion!=null &&
              this.id_Tipo_Transaccion.equals(other.getId_Tipo_Transaccion()))) &&
            ((this.id_Integrador==null && other.getId_Integrador()==null) || 
             (this.id_Integrador!=null &&
              this.id_Integrador.equals(other.getId_Integrador()))) &&
            ((this.cod_Alterno_Distribuidor==null && other.getCod_Alterno_Distribuidor()==null) || 
             (this.cod_Alterno_Distribuidor!=null &&
              this.cod_Alterno_Distribuidor.equals(other.getCod_Alterno_Distribuidor()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            ((this.clave==null && other.getClave()==null) || 
             (this.clave!=null &&
              this.clave.equals(other.getClave()))) &&
            ((this.data_Source==null && other.getData_Source()==null) || 
             (this.data_Source!=null &&
              this.data_Source.equals(other.getData_Source()))) &&
            ((this.parametros_Transaccion==null && other.getParametros_Transaccion()==null) || 
             (this.parametros_Transaccion!=null &&
              this.parametros_Transaccion.equals(other.getParametros_Transaccion())));
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
        if (getId_Instancia() != null) {
            _hashCode += getId_Instancia().hashCode();
        }
        if (getId_Tipo_Transaccion() != null) {
            _hashCode += getId_Tipo_Transaccion().hashCode();
        }
        if (getId_Integrador() != null) {
            _hashCode += getId_Integrador().hashCode();
        }
        if (getCod_Alterno_Distribuidor() != null) {
            _hashCode += getCod_Alterno_Distribuidor().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        if (getClave() != null) {
            _hashCode += getClave().hashCode();
        }
        if (getData_Source() != null) {
            _hashCode += getData_Source().hashCode();
        }
        if (getParametros_Transaccion() != null) {
            _hashCode += getParametros_Transaccion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SreReceptaTransaccionElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicioweb/", ">sreReceptaTransaccionElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_Instancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicioweb/", "Id_Instancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_Tipo_Transaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicioweb/", "Id_Tipo_Transaccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_Integrador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicioweb/", "Id_Integrador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cod_Alterno_Distribuidor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicioweb/", "Cod_Alterno_Distribuidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicioweb/", "Usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clave");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicioweb/", "Clave"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data_Source");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicioweb/", "Data_Source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parametros_Transaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://servicioweb/", "Parametros_Transaccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicioweb/", ">>sreReceptaTransaccionElement>Parametros_Transaccion"));
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
