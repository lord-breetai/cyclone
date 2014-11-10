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

    public static class CountryTable {
        public static final String TABLE_NAME = "country";

        public static final String ID_GENERATOR_NAME = "Country.tableGenerator";

        public static class ColumnName {
            public static final String COUNTRY_ID = "countryid";

            public static final String NAME = "name";

            public static final String CREATE_DATE = "createdate";

            public static final String UPDATE_DATE = "updatedate";

            public static final String VERSION = "version";
        }

        public static class ColumnLength {
            public static final int NAME = 100;
        }
    }

    public static class PersonTable {
        public static final String TABLE_NAME = "person";

        public static final String ID_GENERATOR_NAME = "Person.tableGenerator";

        public static class ColumnName {
            public static final String PERSON_ID = "personid";

            public static final String FIRST_NAME = "firstname";

            public static final String MIDDLE_NAME = "middlename";

            public static final String LAST_NAME = "lastname";

            public static final String BIRTHDAY = "birthday";

            public static final String BIRTH_COUNTRY_ID = "birthcountryid";

            public static final String CREATE_DATE = "createdate";

            public static final String UPDATE_DATE = "updatedate";

            public static final String VERSION = "version";
        }

        public static class ColumnLength {

            public static final int FIRST_NAME = 100;

            public static final int MIDDLE_NAME = 100;

            public static final int LAST_NAME = 100;
        }
    }

    public static class UserTable {
        public static final String TABLE_NAME = "user";

        public static final String ID_GENERATOR_NAME = "User.tableGenerator";

        public static class ColumnName {
            public static final String USER_ID = "userid";

            public static final String USER_NAME = "username";

            public static final String PASSWORD = "password";

            public static final String PERSON_ID = "personid";

            public static final String CREATE_DATE = "createdate";

            public static final String VERSION = "version";
        }

        public static class ColumnLength {
            public static final int USER_NAME = 200;

            public static final int PASSWORD = 200;
        }
    }
}
