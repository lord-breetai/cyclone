package org.alfac.cyclone.model;

/**
 * @author Ivan
 */
public final class Constants {

    private Constants() {
    }

    public static class Sequence {
        public static final String TABLE_NAME = "sequence";

        public static final String PK_COLUMN_NAME = "tablename";

        public static final String VALUE_COLUMN_NAME = "pkvalue";

        public static final int ALLOCATION_SIZE = 10;
    }

    public static class UserTable {
        public static final String TABLE_NAME = "user";

        public static final String ID_GENERATOR_NAME = "User.tableGenerator";

        public static class ColumnName {
            public static final String USER_ID = "userid";

            public static final String USER_NAME = "username";

            public static final String PASSWORD = "password";

            public static final String PERSON_ID = "personid";
        }

        public static class ColumnLength {
            public static final int USER_NAME = 200;

            public static final int PASSWORD = 200;
        }
    }
}
