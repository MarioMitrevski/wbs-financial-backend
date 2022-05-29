package com.example.wbsfinancialbackend.db.sector

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SectorRepository: JpaRepository<Sector, UUID>