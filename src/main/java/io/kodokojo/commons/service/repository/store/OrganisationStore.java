/**
 * Kodo Kojo - Software factory done right
 * Copyright © 2017 Kodo Kojo (infos@kodokojo.io)
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package io.kodokojo.commons.service.repository.store;

import java.util.Set;

public interface OrganisationStore {

    OrganisationStoreModel getOrganisationById(String organisationIdentifier);

    String addOrganisation(OrganisationStoreModel organisation);

    void addAdminToOrganisation(String userIdentifier, String organisationIdentifier);

    void removeAdminToOrganisation(String userIdentifier, String organisationIdentifier);

    void addUserToOrganisation(String userIdentifier, String organisationIdentifier);

    void removeUserToOrganisation(String userIdentifier, String organisationIdentifier);

    void addProjectConfigurationToOrganisation(String organisationId, String projectConfigurationId);

    Set<String> getOrganisationIds();

    OrganisationStoreModel getOrganisationIdByName(String name);
}