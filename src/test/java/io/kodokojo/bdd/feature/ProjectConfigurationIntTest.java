package io.kodokojo.bdd.feature;

/*
 * #%L
 * project-manager
 * %%
 * Copyright (C) 2016 Kodo-kojo
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.junit.ScenarioTest;
import io.kodokojo.bdd.API;
import io.kodokojo.bdd.stage.ApplicationGiven;
import io.kodokojo.bdd.stage.ApplicationThen;
import io.kodokojo.bdd.stage.ApplicationWhen;
import io.kodokojo.commons.DockerIsRequire;
import io.kodokojo.commons.DockerPresentMethodRule;
import org.junit.Rule;
import org.junit.Test;


@As("Project creation scenarios")
@API
public class ProjectConfigurationIntTest extends ScenarioTest<ApplicationGiven<?>, ApplicationWhen<?>, ApplicationThen<?>> {

    @Rule
    public DockerPresentMethodRule dockerPresentMethodRule = new DockerPresentMethodRule();

    @Test
    @DockerIsRequire
    public void create_a_simple_project_configuration() {
        given().redis_is_started()
                .and().kodokojo_restEntrypoint_is_available()
                .and().i_am_user_$("jpthiery", true);
        when().create_a_new_project_configuration_with_name_$("Acme");
        then().it_exist_a_valid_project_configuration_in_store();
    }

    @Test
    @DockerIsRequire
    public void add_a_user_to_project_configuration() {
        given().redis_is_started()
                .and().kodokojo_restEntrypoint_is_available()
                .and().i_am_user_$("jpthiery", true);
        when().create_a_new_project_configuration_with_name_$("Acme")
        .and().create_user_with_email_$("aletaxin@kodokojo.io")
        .and().add_user_$_to_project_configuration("aletaxin");
        then().it_exist_a_valid_project_configuration_in_store_which_contain_user("aletaxin");
    }

    @Test
    @DockerIsRequire
    public void add_a_user_to_project_configuration_as_no_owner_will_fail() {
        given().redis_is_started()
                .and().kodokojo_restEntrypoint_is_available()
                .and().i_am_user_$("jpthiery", true);
        when().create_a_new_project_configuration_with_name_$("Acme")
        .and().create_user_with_email_$("aletaxin@kodokojo.io");
        then().add_user_$_to_project_configuration_as_user_$_will_fail("aletaxin", "aletaxin");
    }

    @Test
    @DockerIsRequire
    public void remove_a_user_to_project_configuration() {
        given().redis_is_started()
                .and().kodokojo_restEntrypoint_is_available()
                .and().i_am_user_$("jpthiery", true);
        when().create_a_new_project_configuration_with_name_$("Acme")
                .and().create_user_with_email_$("aletaxin@kodokojo.io")
                .and().add_user_$_to_project_configuration("aletaxin")
        .and().remove_user_$_to_project_configuration("aletaxin");
        then().it_exist_NOT_a_valid_project_configuration_in_store_which_contain_user("aletaxin");
    }
}
