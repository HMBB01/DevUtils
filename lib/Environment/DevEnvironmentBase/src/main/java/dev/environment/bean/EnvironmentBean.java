package dev.environment.bean;

import java.io.Serializable;

import dev.environment.annotation.Environment;

/**
 * detail: {@link Environment} 实体类
 * @author Ttt
 */
public class EnvironmentBean implements Serializable {

    // 环境名
    private final String name;
    // 环境配置值
    private final String value;
    // 环境别名
    private final String alias;
    // 所属模块
    private final ModuleBean module;
    // 是否选中当前环境
    private boolean checked;

    public EnvironmentBean(String name, String value, String alias, ModuleBean module, boolean checked) {
        this.name = name;
        this.value = value;
        this.alias = alias;
        this.module = module;
        this.checked = checked;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public String getValue() {
        return value == null ? "" : value;
    }

    public String getAlias() {
        return alias == null ? "" : alias;
    }

    public ModuleBean getModule() {
        return module;
    }

    public boolean isChecked() {
        return checked;
    }

    public EnvironmentBean setChecked(boolean checked) {
        this.checked = checked;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        EnvironmentBean that = (EnvironmentBean) object;
        if (checked != that.checked) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (alias != null ? !alias.equals(that.alias) : that.alias != null) return false;
        return module != null ? module.equals(that.module) : that.module == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (checked ? 1 : 0);
        return result;
    }

    private final String JSON_FORMAT = "{\"name\":\"%s\",\"value\":\"%s\",\"alias\":\"%s\",\"module\":{\"name\":\"%s\",\"alias\":\"%s\"},\"checked\":%s}";

    @Override
    public String toString() {
        String moduleName = (module != null) ? module.getName() : "";
        String moduleAlias = (module != null) ? module.getAlias() : "";
        return String.format(JSON_FORMAT, getName(), getValue(), getAlias(), moduleName, moduleAlias, isChecked());
    }
}