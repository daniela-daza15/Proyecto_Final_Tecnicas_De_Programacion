<%-- 
    Document   : index
    Created on : 17/06/2025, 1:52:29 a. m.
    Author     : danis
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zenda Studio - Agencia Publicitaria</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="img/zenda_icon_v2.png.png">
</head>
<body>
    <!-- Sidebar Navigation -->
    <nav class="sidebar" id="sidebar">
        <div class="sidebar-header">
            <div class="logo">
                <div class="logo-icon"><img src="img/zenda_logo.png" width="50"></div>
                <div class="logo-text">
                    <h1>Zenda Studio</h1>
                    <p>Agencia Publicitaria</p>
                </div>
            </div>
        </div>

        <ul class="nav-menu">
            <li class="nav-item">
                <a href="#inicio" class="nav-link active" data-section="inicio">
                    <span class="nav-icon">✔︎</span>
                    <span class="nav-text">Inicio</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="#servicios" class="nav-link" data-section="servicios">
                    <span class="nav-icon">♟︎</span>
                    <span class="nav-text">Servicios</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="#portafolio" class="nav-link" data-section="portafolio">
                    <span class="nav-icon">⚜︎</span>
                    <span class="nav-text">Portafolio</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="#contacto" class="nav-link" data-section="contacto">
                    <span class="nav-icon">✉︎</span>
                    <span class="nav-text">Contacto</span>
                </a>
            </li>
        </ul>

        <div class="sidebar-footer">
            <div class="call-to-action">
                <p><strong>¿Tienes un proyecto?</strong></p>
                <p>Contáctanos para una consulta gratuita</p>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <main class="main-content">
        <%-- INICIO --%>
        <section id="inicio" class="section active">
            <div class="hero-container">
                <div class="hero-content">
                    <div class="hero-badge">
                        <span>Agencia Líder en Publicidad Digital</span>
                    </div>
                    <h1 class="hero-title">
                        Transformamos Ideas en
                        <span class="hero-highlight">Campañas Exitosas</span>
                    </h1>
                    <p class="hero-description">
                        Somos Zenda Studio, una agencia de publicidad innovadora que ayuda a las marcas a conectar 
                        con su audiencia a través de estrategias creativas y resultados medibles.
                    </p>
                    
                    <div class="hero-buttons">
                        <button class="btn-primary" onclick="showSection('portafolio')">
                            Ver Nuestros Proyectos
                            <span class="btn-icon">→</span>
                        </button>
                        <button class="btn-secondary" onclick="showSection('servicios')">
                            Conocer Servicios
                        </button>
                    </div>

                    <div class="stats-grid">
                        <div class="stat-card">
                            <div class="stat-number">150+</div>
                            <div class="stat-label">Proyectos Completados</div>
                        </div>
                        <div class="stat-card">
                            <div class="stat-number">98%</div>
                            <div class="stat-label">Satisfacción del Cliente</div>
                        </div>
                        <div class="stat-card">
                            <div class="stat-number">5+</div>
                            <div class="stat-label">Años de Experiencia</div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%-- SERVICIOS --%>
        <section id="servicios" class="section">
            <div class="container">
                <div class="section-header">
                    <br>
                    <h2>Nuestros Servicios</h2>
                    <p>Ofrecemos soluciones integrales de publicidad digital para hacer crecer tu negocio</p>
                </div>

                <div class="services-grid">
                    <div class="service-card">
                        <h3>Marketing Digital</h3>
                        <p>Estrategias digitales completas para aumentar tu presencia online y generar más conversiones.</p>
                    </div>
                    <div class="service-card">
                        <h3>Diseño Gráfico</h3>
                        <p>Creamos identidades visuales únicas que representan la esencia de tu marca de manera impactante.</p>
                    </div>
                    <div class="service-card">
                        <h3>Publicidad en Redes</h3>
                        <p>Campañas efectivas en Facebook, Instagram, LinkedIn y otras plataformas sociales.</p>
                    </div>
                    <div class="service-card">
                        <h3>SEO & SEM</h3>
                        <p>Optimización para motores de búsqueda y campañas de publicidad pagada para maximizar tu alcance.</p>
                    </div>
                    <div class="service-card">
                        <h3>Producción de Video</h3>
                        <p>Videos promocionales, corporativos y publicitarios que conectan emocionalmente con tu audiencia.</p>
                    </div>
                    <div class="service-card">
                        <h3>Consultoría</h3>
                        <p>Asesoramiento estratégico para definir y ejecutar planes de marketing efectivos.</p>
                    </div>
                </div>
            </div>
        </section>

        <%-- PORTAFOLIO --%>
        <section id="portafolio" class="section">
            <div class="container">
                <div class="section-header">
                    <br>
                    <h2>Nuestro Portafolio</h2>
                    <p>Algunos de los proyectos exitosos que hemos desarrollado para nuestros clientes</p>
                </div>

                <div class="portfolio-grid">
                    <div class="portfolio-item">
                        <div class="portfolio-image">
                            <img src="img/portafolio/proyecto_1.jpg" alt="Campaña Digital - IKEA" class="portfolio-img">
                        </div>
                        <div class="portfolio-info">
                            <h3>Campaña Digital - IKEA</h3>
                            <p>Aumento del 300% en conversiones</p>
                        </div>
                    </div>
                    <div class="portfolio-item">
                        <div class="portfolio-image">
                            <img src="img/portafolio/proyecto_2.jpg" alt="Rebranding - Mooi" class="portfolio-img">
                        </div>
                        <div class="portfolio-info">
                            <h3>Rebranding - Mooi</h3>
                            <p>Nueva identidad visual completa</p>
                        </div>
                    </div>
                    <div class="portfolio-item">
                        <div class="portfolio-image">
                            <img src="img/portafolio/proyecto_3.jpg" alt="Campaña Social - Azteca" class="portfolio-img">
                        </div>
                        <div class="portfolio-info">
                            <h3>Campaña Social - Azteca</h3>
                            <p>50k nuevos seguidores en 3 meses</p>
                        </div>
                    </div>
                    <div class="portfolio-item">
                        <div class="portfolio-image">
                            <img src="img/portafolio/proyecto_4.jpg" alt="E-commerce - Nova Wear" class="portfolio-img">
                        </div>
                        <div class="portfolio-info">
                            <h3>E-commerce - Nova Wear</h3>
                            <p>Incremento del 250% en ventas online</p>
                        </div>
                    </div>
                    <div class="portfolio-item">
                        <div class="portfolio-image">
                            <img src="img/portafolio/proyecto_5.jpg" alt="Video Corporativo - FinTech" class="portfolio-img">
                        </div>
                        <div class="portfolio-info">
                            <h3>Video Corporativo - FinTech</h3>
                            <p>1M de visualizaciones en YouTube</p>
                        </div>
                    </div>
                    <div class="portfolio-item">
                        <div class="portfolio-image">
                            <img src="img/portafolio/proyecto_6.jpg" alt="SEO Strategy - Workana" class="portfolio-img">
                        </div>
                        <div class="portfolio-info">
                            <h3>SEO Strategy - Workana</h3>
                            <p>Primera posición en Google</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%-- CONTACTO --%>
        <section id="contacto" class="section">
            <div class="container">
                <div class="section-header">
                    <br>
                    <h2>Contáctanos</h2>
                    <p>¿Listo para llevar tu negocio al siguiente nivel? Completa el formulario y nos pondremos en contacto contigo</p>
                </div>

                <div class="contact-content">
                    <div class="contact-form-container">
                        <div class="contact-form" style="display: flex; flex-direction: column; align-items: center; justify-content: center; gap: 1rem;">
                            <p style="text-align: center;">Haz clic en el siguiente botón para ir al formulario de contacto:</p>
                            <a href="formulario.jsp">
                                <button class="btn-primary">
                                    Ir al formulario de contacto
                                    <span class="btn-icon">→</span>
                                </button>
                            </a>
                        </div>
                    </div>

                    <div class="contact-info">
                        <div class="info-item">
                            <h3>📧 Email</h3>
                            <p>info@studiozenda.com</p>
                        </div>
                        <div class="info-item">
                            <h3>📞 Teléfono</h3>
                            <p>601 (553) 123-4567</p>
                        </div>
                        <div class="info-item">
                            <h3>📍 Oficina</h3>
                            <p>123 Zenda Studio<br>Medellín, Antioquia</p>
                        </div>
                        <div class="info-item">
                            <h3>🕒 Horarios</h3>
                            <p>Lun - Vie: 9:00 AM - 6:00 PM<br>Sáb: 10:00 AM - 2:00 PM</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <script src="js/script.js"></script>
</body>
</html>

