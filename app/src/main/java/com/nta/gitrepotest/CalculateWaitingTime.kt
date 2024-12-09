package com.nta.gitrepotest

data class Doctor(
    val name: String,
    val avgConsultationTime: Double
) {
    val consultationRate: Double
        get() = 1 / avgConsultationTime
}

fun calculateWaitingTime(doctors: ArrayList<Doctor>, patientPosition: Int): Double {

    if (doctors.isEmpty() || patientPosition <= 0) {
        return 0.0
    }

    // Step 1: Calculate total consultation rate
    val totalConsultationRate = doctors.sumOf { it.consultationRate }

    // Step 2: Calculate waiting time for patient and return waiting time
    return (patientPosition - 1) / totalConsultationRate

}

fun main() {

    val doctors = arrayListOf(
        Doctor("Doctor A", 3.0),
        Doctor("Doctor B", 4.0)
    )
    val patientPosition = 11

    val waitingTime = calculateWaitingTime(doctors, patientPosition)

    println("Estimated waiting time for patient $patientPosition: ${"%.2f".format(waitingTime)} minutes")
}