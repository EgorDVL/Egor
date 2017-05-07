package com.zhyzhko.dto;

/**
 * Created by Egor on 09.04.2017.
 */
public class FieldDto {
    private int id;
    private String label;
    private TypeDto type;
    private RequiredDto required;
    private StatusDto status;

    public FieldDto() {
    }

    public FieldDto(String label, TypeDto type, RequiredDto required, StatusDto status) {
        this.label = label;
        this.type = type;
        this.required = required;
        this.status = status;
    }

    public FieldDto(int id, String label, TypeDto type, RequiredDto required, StatusDto status) {
        this(label, type, required, status);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public TypeDto getType() {
        return type;
    }

    public void setType(TypeDto type) {
        this.type = type;
    }

    public RequiredDto getRequired() {
        return required;
    }

    public void setRequired(RequiredDto required) {
        this.required = required;
    }

    public StatusDto getStatus() {
        return status;
    }

    public void setStatus(StatusDto status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldDto fieldDto = (FieldDto) o;

        if (id != fieldDto.id) return false;
        if (label != null ? !label.equals(fieldDto.label) : fieldDto.label != null) return false;
        if (type != null ? !type.equals(fieldDto.type) : fieldDto.type != null) return false;
        if (required != null ? !required.equals(fieldDto.required) : fieldDto.required != null) return false;
        return !(status != null ? !status.equals(fieldDto.status) : fieldDto.status != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (required != null ? required.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FieldDto{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", required=" + required +
                ", status=" + status +
                '}';
    }
}
