/**
 * Kodo Kojo - Software factory done right
 * Copyright © 2017 Kodo Kojo (infos@kodokojo.io)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package io.kodokojo.commons.config;

import io.kodokojo.commons.config.properties.Key;
import io.kodokojo.commons.config.properties.PropertyConfig;

public interface RedisConfig extends PropertyConfig {

    String REDIS_HOST = "redis.host";

    String REDIS_PORT = "redis.port";

    String REDIS_PASSWORD = "redis.password";

    @Key(value = REDIS_HOST, defaultValue = "redis")
    String host();

    @Key(value = REDIS_PORT, defaultValue = "6379")
    Integer port();

    @Key(value = REDIS_PASSWORD)
    String password();

}
