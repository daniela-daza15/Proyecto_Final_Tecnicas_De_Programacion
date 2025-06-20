// Variables globales
let activeSection = 'inicio';
let isMobile = window.innerWidth <= 768;

// Inicialización cuando se carga la página
document.addEventListener('DOMContentLoaded', function() {
    initializeNavigation();
    initializeContactForm();
    initializeResponsive();
    
    // Mostrar la sección inicial con animación
    showSection('inicio');
});

// Inicializar navegación
function initializeNavigation() {
    const navLinks = document.querySelectorAll('.nav-link');
    
    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            const section = this.getAttribute('data-section');
            showSection(section);
            updateActiveNavLink(this);
            
            // Cerrar sidebar en móvil después de seleccionar
            if (isMobile) {
                closeSidebar();
            }
        });
    });
}

// Mostrar sección específica
function showSection(sectionName) {
    // Ocultar todas las secciones
    const sections = document.querySelectorAll('.section');
    sections.forEach(section => {
        section.classList.remove('active');
    });
    
    // Mostrar la sección seleccionada
    const targetSection = document.getElementById(sectionName);
    if (targetSection) {
        targetSection.classList.add('active');
        targetSection.classList.add('fade-in');
        
        // Remover la clase de animación después de que termine
        setTimeout(() => {
            targetSection.classList.remove('fade-in');
        }, 500);
    }
    
    // Actualizar la sección activa
    activeSection = sectionName;
    
    // Actualizar el enlace activo en la navegación
    updateActiveNavLink(document.querySelector(`[data-section="${sectionName}"]`));
    
    // Scroll al top de la sección
    window.scrollTo({ top: 0, behavior: 'smooth' });
}

// Actualizar enlace activo en navegación
function updateActiveNavLink(activeLink) {
    // Remover clase active de todos los enlaces
    const navLinks = document.querySelectorAll('.nav-link');
    navLinks.forEach(link => {
        link.classList.remove('active');
    });
    
    // Agregar clase active al enlace seleccionado
    if (activeLink) {
        activeLink.classList.add('active');
    }
}

// Inicializar formulario de contacto
function initializeContactForm() {
    const contactForm = document.getElementById('contactForm');
    
    if (contactForm) {
        contactForm.addEventListener('submit', function(e) {
            e.preventDefault();
            handleFormSubmission(this);
        });
    }
}

// Manejar envío del formulario
function handleFormSubmission(form) {
    // Obtener datos del formulario
    const formData = new FormData(form);
    const data = {};
    
    formData.forEach((value, key) => {
        data[key] = value;
    });
    
    // Validar campos requeridos
    if (!validateForm(data)) {
        return;
    }
    
    // Simular envío del formulario
    const submitButton = form.querySelector('button[type="submit"]');
    const originalText = submitButton.innerHTML;
    
    // Cambiar texto del botón mientras se "envía"
    submitButton.innerHTML = 'Enviando...';
    submitButton.disabled = true;
    
    // Simular delay de envío
    setTimeout(() => {
        // Mostrar mensaje de éxito
        showSuccessMessage();
        
        // Resetear formulario
        form.reset();
        
        // Restaurar botón
        submitButton.innerHTML = originalText;
        submitButton.disabled = false;
    }, 2000);
}

// Validar formulario
function validateForm(data) {
    const requiredFields = ['nombre', 'email', 'servicio'];
    const errors = [];
    
    requiredFields.forEach(field => {
        if (!data[field] || data[field].trim() === '') {
            errors.push(`El campo ${field} es requerido`);
        }
    });
    
    // Validar email
    if (data.email && !isValidEmail(data.email)) {
        errors.push('El formato del email no es válido');
    }
    
    if (errors.length > 0) {
        showErrorMessage(errors.join(', '));
        return false;
    }
    
    return true;
}

// Validar formato de email
function isValidEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

// Mostrar mensaje de éxito
function showSuccessMessage() {
    showNotification('¡Mensaje enviado exitosamente! Nos pondremos en contacto contigo pronto.', 'success');
}

// Mostrar mensaje de error
function showErrorMessage(message) {
    showNotification(message, 'error');
}

// Sistema de notificaciones
function showNotification(message, type) {
    // Crear elemento de notificación
    const notification = document.createElement('div');
    notification.className = `notification ${type}`;
    notification.innerHTML = `
        <div class="notification-content">
            <span class="notification-icon">${type === 'success' ? '✅' : '❌'}</span>
            <span class="notification-text">${message}</span>
            <button class="notification-close" onclick="closeNotification(this)">&times;</button>
        </div>
    `;
    
    // Agregar estilos si no existen
    if (!document.querySelector('#notification-styles')) {
        const styles = document.createElement('style');
        styles.id = 'notification-styles';
        styles.textContent = `
            .notification {
                position: fixed;
                top: 20px;
                right: 20px;
                padding: 1rem;
                border-radius: 0.5rem;
                color: white;
                z-index: 9999;
                max-width: 400px;
                animation: slideInRight 0.3s ease-out;
            }
            .notification.success {
                background: #10b981;
            }
            .notification.error {
                background: #ef4444;
            }
            .notification-content {
                display: flex;
                align-items: center;
                gap: 0.5rem;
            }
            .notification-close {
                background: none;
                border: none;
                color: white;
                font-size: 1.5rem;
                cursor: pointer;
                margin-left: auto;
            }
            @keyframes slideInRight {
                from {
                    transform: translateX(100%);
                    opacity: 0;
                }
                to {
                    transform: translateX(0);
                    opacity: 1;
                }
            }
        `;
        document.head.appendChild(styles);
    }
    
    // Agregar al DOM
    document.body.appendChild(notification);
    
    // Auto-remover después de 5 segundos
    setTimeout(() => {
        if (notification.parentNode) {
            closeNotification(notification.querySelector('.notification-close'));
        }
    }, 5000);
}

// Cerrar notificación
function closeNotification(button) {
    const notification = button.closest('.notification');
    notification.style.animation = 'slideOutRight 0.3s ease-out';
    setTimeout(() => {
        if (notification.parentNode) {
            notification.parentNode.removeChild(notification);
        }
    }, 300);
}

// Funcionalidades responsivas
function initializeResponsive() {
    window.addEventListener('resize', function() {
        const newIsMobile = window.innerWidth <= 768;
        
        if (newIsMobile !== isMobile) {
            isMobile = newIsMobile;
            handleResponsiveChange();
        }
    });
    
    // Agregar botón de menú móvil si no existe
    if (isMobile && !document.querySelector('.mobile-menu-toggle')) {
        addMobileMenuToggle();
    }
}

// Manejar cambios responsivos
function handleResponsiveChange() {
    const sidebar = document.querySelector('.sidebar');
    
    if (!isMobile) {
        // Desktop: mostrar sidebar
        sidebar.classList.remove('active');
    } else {
        // Móvil: ocultar sidebar y agregar toggle
        sidebar.classList.remove('active');
        if (!document.querySelector('.mobile-menu-toggle')) {
            addMobileMenuToggle();
        }
    }
}

// Agregar botón de menú móvil
function addMobileMenuToggle() {
    const toggle = document.createElement('button');
    toggle.className = 'mobile-menu-toggle';
    toggle.innerHTML = '☰';
    toggle.onclick = toggleSidebar;
    
    // Estilos para el botón
    const styles = document.createElement('style');
    styles.textContent = `
        .mobile-menu-toggle {
            position: fixed;
            top: 20px;
            left: 20px;
            z-index: 9999;
            background: var(--primary-color);
            color: white;
            border: none;
            padding: 0.75rem;
            border-radius: 0.5rem;
            font-size: 1.25rem;
            cursor: pointer;
            display: none;
            box-shadow: var(--shadow);
        }
        @media (max-width: 768px) {
            .mobile-menu-toggle {
                display: block;
            }
        }
    `;
    
    if (!document.querySelector('#mobile-styles')) {
        styles.id = 'mobile-styles';
        document.head.appendChild(styles);
    }
    
    document.body.appendChild(toggle);
}

// Toggle sidebar móvil
function toggleSidebar() {
    const sidebar = document.querySelector('.sidebar');
    sidebar.classList.toggle('active');
}

// Cerrar sidebar móvil
function closeSidebar() {
    const sidebar = document.querySelector('.sidebar');
    sidebar.classList.remove('active');
}

// Funciones auxiliares para navegación desde botones
function navigateToSection(sectionName) {
    showSection(sectionName);
}

// Cerrar sidebar al hacer clic fuera de él (solo móvil)
document.addEventListener('click', function(e) {
    if (isMobile) {
        const sidebar = document.querySelector('.sidebar');
        const toggle = document.querySelector('.mobile-menu-toggle');
        
        if (!sidebar.contains(e.target) && !toggle.contains(e.target)) {
            closeSidebar();
        }
    }
});

// Funcionalidad de scroll suave para enlaces internos
function smoothScrollTo(elementId) {
    const element = document.getElementById(elementId);
    if (element) {
        element.scrollIntoView({
            behavior: 'smooth',
            block: 'start'
        });
    }
}

// Agregar efectos de hover y animaciones adicionales
document.addEventListener('DOMContentLoaded', function() {
    // Agregar efecto parallax sutil al hero
    window.addEventListener('scroll', function() {
        const scrolled = window.pageYOffset;
        const hero = document.querySelector('.hero-container');
        
        if (hero && scrolled < window.innerHeight) {
            hero.style.transform = `translateY(${scrolled * 0.5}px)`;
        }
    });
    
    // Agregar animación de entrada a las tarjetas cuando entran en viewport
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };
    
    const observer = new IntersectionObserver(function(entries) {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.animation = 'fadeIn 0.6s ease-out forwards';
            }
        });
    }, observerOptions);
    
    // Observar elementos que necesiten animación
    const animatedElements = document.querySelectorAll('.service-card, .portfolio-item, .stat-card');
    animatedElements.forEach(el => {
        el.style.opacity = '0';
        observer.observe(el);
    });
});

// Función para debugging (opcional)
function debugInfo() {
    console.log('ZendaStudio Website Debug Info:');
    console.log('Active Section:', activeSection);
    console.log('Is Mobile:', isMobile);
    console.log('Window Width:', window.innerWidth);
}

// Exportar funciones globales para uso en HTML
window.showSection = showSection;
window.navigateToSection = navigateToSection;
window.toggleSidebar = toggleSidebar;
window.closeSidebar = closeSidebar;
window.closeNotification = closeNotification;
window.debugInfo = debugInfo;