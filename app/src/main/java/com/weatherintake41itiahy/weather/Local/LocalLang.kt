package com.weatherintake41itiahy.weather.Local

import com.weatherintake41itiahy.weather.R

class LocalLang {
    companion object {
        fun getMainWeatherSate(main: String): Int {
            when (main) {
                "Thunderstorm" -> {
                    return R.string.thunderstorm
                }
                "Drizzle" -> {
                    return R.string.Drizzle
                }
                "Rain" -> {
                    return R.string.rain
                }
                "Snow" -> {
                    return R.string.snow
                }
                "Mist" -> {
                    return R.string.Mist
                }
                "Smoke" -> {
                    return R.string.Smoke
                }
                "Haze" -> {
                    return R.string.Haze
                }
                "Dust" -> {
                    return R.string.Dust
                }
                "Fog" -> {
                    return R.string.Fog
                }
                "Sand" -> {
                    return R.string.Sand
                }
                "Ash" -> {
                    return R.string.Ash
                }
                "Squall" -> {
                    return R.string.Squall
                }
                "Tornado" -> {
                    return R.string.Tornado
                }
                "Clear" -> {
                    return R.string.Clear
                }
                "Clouds" -> {
                    return R.string.Clouds

                }
            }
            return 0
        }
        fun getMainWeatherAlert(des: String): Int {
            when (des) {
                "wind" -> {
                    return R.string.wind_speed
                }
                "Thunderstorm" -> {
                    return R.string.thunderstorm
                }
                "Mist,Smoke,Haze,Fog,Sand,Dust,Tornado,Squall,Ash" -> {
                    return R.string.mist_fog_haze
                }
                "Snow" -> {
                    return R.string.snow
                }
                "cloud" -> {
                    return R.string.clouds
                }
                "Rain" -> {
                    return R.string.rain
                }
                "temp" -> {
                    return R.string.temperature
                }

            }
            return 0
        }
        fun getDecWeatherSate(des: String): Int {
            when (des) {
                "thunderstorm with light rain" -> {
                    return R.string.thunderstorm_with_light_rain
                }
                "thunderstorm with rain" -> {
                    return R.string.thunderstorm_with_rain
                }
                "thunderstorm with heavy rain" -> {
                    return R.string.thunderstorm_with_heavy_rain
                }
                "light thunderstorm" -> {
                    return R.string.light_thunderstorm
                }
                "thunderstorm" -> {
                    return R.string.thunderstorm
                }
                "heavy thunderstorm" -> {
                    return R.string.heavy_thunderstorm
                }
                "ragged thunderstorm" -> {
                    return R.string.ragged_thunderstorm
                }
                "thunderstorm with light drizzle" -> {
                    return R.string.thunderstorm_with_light_drizzle
                }
                "thunderstorm with drizzle" -> {
                    return R.string.thunderstorm_with_drizzle
                }
                "thunderstorm with heavy drizzle" -> {
                    return R.string.thunderstorm_with_heavy_drizzle
                }
                "light intensity drizzle" -> {
                    return R.string.light_intensity_drizzle
                }
                "drizzle" -> {
                    return R.string.Drizzle
                }
                "heavy intensity drizzle" -> {
                    return R.string.heavy_intensity_drizzle
                }
                "light intensity drizzle rain" -> {
                    return R.string.light_intensity_drizzle_rain
                }
                "drizzle rain" -> {
                    return R.string.drizzle_rain

                }
                "heavy intensity drizzle rain" -> {
                    return R.string.heavy_intensity_drizzle_rain
                }
                "shower rain and drizzle" -> {
                    return R.string.shower_rain_and_drizzle
                }
                "heavy shower rain and drizzle" -> {
                    return R.string.heavy_shower_rain_and_drizzle
                }
                "shower drizzle" -> {
                    return R.string.shower_drizzle

                }
                "light rain" -> {
                    return R.string.light_rain
                }
                "moderate rain" -> {
                    return R.string.moderate_rain
                }
                "heavy intensity rain" -> {
                    return R.string.heavy_intensity_rain

                }
                "very heavy rain" -> {
                    return R.string.very_heavy_rain
                }
                "extreme rain" -> {
                    return R.string.extreme_rain
                }
                "freezing rain" -> {
                    return R.string.freezing_rain
                }
                "light intensity shower rain" -> {
                    return R.string.light_intensity_shower_rain

                }
                "shower rain" -> {
                    return R.string.shower_rain
                }
                "heavy intensity shower rain" -> {
                    return R.string.heavy_intensity_shower_rain
                }
                "ragged shower rain" -> {
                    return R.string.ragged_shower_rain

                }
                "light snow" -> {
                    return R.string.light_snow
                }
                "Snow" -> {
                    return R.string.snow

                }
                "Heavy snow" -> {
                    return R.string.Heavy_snow
                }
                "Sleet" -> {
                    return R.string.Sleet
                }
                "Light shower sleet" -> {
                    return R.string.Light_shower_sleet
                }
                "Shower sleet" -> {
                    return R.string.Shower_sleet

                }
                "Light rain and snow" -> {
                    return R.string.Light_rain_and_snow
                }
                "Rain and snow" -> {
                    return R.string.Rain_and_snow
                }
                "Light shower snow" -> {
                    return R.string.Light_shower_snow

                }
                "Shower snow" -> {
                    return R.string.Shower_snow

                }
                "Heavy shower snow" -> {
                    return R.string.Heavy_shower_snow

                }
                "mist" -> {
                    return R.string.Mist
                }
                "Smoke" -> {
                    return R.string.Smoke
                }
                "Haze" -> {
                    return R.string.Haze
                }
                "Dust" -> {
                    return R.string.Dust
                }
                "fog" -> {
                    return R.string.Fog
                }
                "sand" -> {
                    return R.string.Sand
                }
                "volcanic ash" -> {
                    return R.string.Ash
                }
                "squalls" -> {
                    return R.string.Squall
                }
                "tornado" -> {
                    return R.string.Tornado
                }
                "clear sky" -> {
                    return R.string.clear_sky
                }
                "few clouds" -> {
                    return R.string.few_clouds
                }
                "scattered clouds" -> {
                    return R.string.scattered_clouds
                }
                "broken clouds" -> {
                    return R.string.broken_clouds
                }
                "overcast clouds" -> {
                    return R.string.overcast_clouds
                }
            }
            return 0
        }
    }


}