package eu.lengarski.usermanagment;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Georgi Lengarski on  Thursday 12/08/2021   08:08
 */
public class UserManagmentSystemConstants
{
    public static final String DB_URL_PREFIX = "jdbc:mysql://";
    public static final String DB_URL_SUFIX = ":3306/usermanagment?serverTimezone=UTC";

    public static final String DB_USERNAME = "ums";
    public static final String DB_PASSWORD = "umsumsums";
}
