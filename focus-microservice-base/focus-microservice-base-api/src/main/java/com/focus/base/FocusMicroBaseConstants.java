package com.focus.base;

public class FocusMicroBaseConstants {

    public static final String SERVICE_APP_ID = "focus-base";

    public static final String SUCCESS = "success";

    public static  final String REDIS_RESOURCE_TREE = "REDIS_RESOURCE_TREE";

    public  enum UserStatus{
        NORMAL("正常",1),DELETE("删除",2);

        private String name;
        private Integer value;

        public String getName() {
            return name;
        }

        public Integer getValue() {
            return value;
        }

        UserStatus(String name, Integer value) {
            this.name = name;
            this.value = value;
        }
    }

    public enum UserSex{
        MAN("男",true),WOMAN("女",false);

        private String name;
        private Boolean value;

        public Boolean getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        UserSex(String name, Boolean value) {
            this.name = name;
            this.value = value;
        }
    }

    public enum UserType{
        SYSTEM("系统用户",1),
        CUSTOMIZE("自定义用户",2);

        private String name;
        private Integer value;

        public String getName() {
            return name;
        }

        public Integer getValue() {
            return value;
        }

        UserType(String name, Integer value) {
            this.name = name;
            this.value = value;
        }
    }

    public enum RoleType{
        SYSTEM("系统用户",1),
        CUSTOMIZE("自定义用户",2);

        private String name;
        private Integer value;

        public String getName() {
            return name;
        }

        public Integer getValue() {
            return value;
        }

        RoleType(String name, Integer value) {
            this.name = name;
            this.value = value;
        }
    }

    public enum RoleStatus{
        NORMAL("正常",1),
        DELETE("删除",2);

        private String name;
        private Integer value;

        public String getName() {
            return name;
        }

        public Integer getValue() {
            return value;
        }

        RoleStatus(String name, Integer value) {
            this.name = name;
            this.value = value;
        }
    }
}
