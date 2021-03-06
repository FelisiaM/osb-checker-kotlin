package de.evoila.osb.checker.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class PlanMetadata(
    val displayName: String?,
    val customParameters: CustomParameters?
)