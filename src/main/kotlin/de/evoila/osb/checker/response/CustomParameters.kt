package de.evoila.osb.checker.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CustomParameters(
    val usesServicesKeys: Boolean?
)