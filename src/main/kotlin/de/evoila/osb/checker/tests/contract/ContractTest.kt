package de.evoila.osb.checker.tests.contract

import com.greghaskins.spectrum.Spectrum
import com.greghaskins.spectrum.Spectrum.describe
import com.greghaskins.spectrum.Spectrum.it
import de.evoila.osb.checker.Application
import de.evoila.osb.checker.config.Configuration.Companion.NOT_AN_ID
import de.evoila.osb.checker.config.Configuration.Companion.token
import de.evoila.osb.checker.request.BindingRequestRunner
import de.evoila.osb.checker.request.CatalogRequestRunner
import de.evoila.osb.checker.request.ProvisionRequestRunner
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [Application::class])
@RunWith(Spectrum::class)
class ContractTest(
) {
  init {
    describe("Requests should contain header X-Broker-API-Version: 2.13") {

      val catalogRequestRunner = CatalogRequestRunner(token)
      val provisionRequestRunner = ProvisionRequestRunner(NOT_AN_ID)
      val bindingRequestRunner = BindingRequestRunner(NOT_AN_ID, NOT_AN_ID)

      it("GET - v2/catalog should reject with 412") {
        catalogRequestRunner.withoutHeader()
      }

      it("PUT - v2/service_instance/instance_id should reject with 412") {
        provisionRequestRunner.putWithoutHeader()
      }

      it("GET - v2/service_instance/instance_id/last_operation should reject with 412") {
        provisionRequestRunner.lastOperationWithoutHeader()
      }

      it("DELETE - v2/service_instance/instance_id should reject with 412") {
        provisionRequestRunner.deleteWithoutHeader("Invalid", "Invalid")
      }

      it("PUT - v2/service_instance/instance_id/service_binding/binding_id  should reject with 412") {
        bindingRequestRunner.putWithoutHeader()
      }

      it("DELETE - v2/service_instance/instance_id/service_binding/binding_id  should reject with 412") {
        bindingRequestRunner.deleteWithoutHeader()
      }
    }
  }
}