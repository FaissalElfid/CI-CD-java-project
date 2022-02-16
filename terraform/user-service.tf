resource "kubernetes_deployment" "user_service_app" {
  metadata {
    name = "employee-service-app"

    labels = {
      app = "employee-service-app"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels = {
        app = "employee-service-app"
      }
    }

    template {
      metadata {
        labels = {
          app = "employee-service-app"
        }
      }

      spec {
        container {
          name  = "employee-service-app"
          image = "faissalelfid/employee-service:0.0.1"

          port {
            container_port = 9002
          }

          image_pull_policy = "Always"
        }
      }
    }
  }
}

resource "kubernetes_service" "user_service_svc" {
  metadata {
    name = "employee-service-svc"
  }

  spec {
    port {
      port        = 80
      target_port = "9002"
    }

    selector = {
      app = "employee-service-app"
    }
  }
}

