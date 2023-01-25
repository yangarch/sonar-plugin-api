/*
 * Sonar Plugin API
 * Copyright (C) 2009-2023 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.api.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapConfiguration implements Configuration {
  private final Map<String, String> keyValues = new HashMap<>();

  public Configuration put(String key, String value) {
    keyValues.put(key, value.trim());
    return this;
  }

  @Override
  public Optional<String> get(String key) {
    return Optional.ofNullable(keyValues.get(key));
  }

  @Override
  public boolean hasKey(String key) {
    return get(key).isPresent();
  }

  @Override
  public String[] getStringArray(String key) {
    return get(key).map(x -> x.split(",")).orElse(new String[0]);
  }
}
