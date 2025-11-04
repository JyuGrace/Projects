Análisis de Diabetes Pima y Modelo Predictivo

Este proyecto realiza un análisis estadístico inferencial profundo y construye un modelo de machine learning para predecir la aparición de diabetes basándose en el conjunto de datos de los "Pima Indians Diabetes".
El enfoque principal de este notebook es demostrar un flujo de trabajo riguroso, justificando cada paso metodológico, desde la imputación de datos hasta la selección de pruebas de inferencia no paramétricas y, finalmente, el modelado.

Metodología del Proyecto

El proyecto sigue un flujo estructurado de análisis y modelado:

1.	Limpieza e Imputación de Datos:
o	Se identificaron valores faltantes (registrados como 0) en variables clave (Glucose, BMI, Insulin, etc.).
o	Se compararon dos técnicas de imputación: Mediana y KNNImputer (K-Vecinos Más Cercanos).
o	El KNNImputer fue seleccionado, ya que preservó la distribución natural de los datos sin crear picos artificiales en la mediana.

2.	Análisis Exploratorio de Datos (EDA) Visual:
o	Se generó un pairplot (matriz de gráficos de dispersión) para visualizar las relaciones bivariadas.
o	Se utilizó la Estimación de Densidad Kernel (KDE) en la diagonal para evaluar visualmente la forma de la distribución (PDF) de cada variable, revelando un fuerte sesgo positivo (no normalidad) en la mayoría de los predictores.

3.	Justificación de Pruebas No Paramétricas:
o	Test de Shapiro-Wilk y Test de Kolmogorov-Smirnov (K-S) se aplicaron a todos los predictores.
o	Ambas pruebas rechazaron la hipótesis nula (H0) de normalidad para todas las variables, justificando formalmente el uso exclusivo de métodos no paramétricos.

4.	Análisis de Asociación (Correlación):
o	Se comparó la correlacion de Pearson (específicamente, la Correlación Biserial-Puntual para el Outcome binario) con la correlacion de Spearman.
o	Se detectó multicolinealidad significativa (ej. Glucose vs Insulin; BMI vs SkinThickness).
o	Se calculó la matriz de P-values de Spearman para confirmar que todas las asociaciones clave eran estadísticamente significativas (P < 0.05).

5.	Inferencia Estadística Formal:
o	Test U de Mann-Whitney (MWU): Se utilizó para probar formalmente la diferencia de distribuciones entre los grupos Outcome=0 (No Diabético) y Outcome=1 (Diabético).
o	Test Chi-Cuadrado : Se realizó un análisis complementario discretizando (pd.cut) las variables continuas (Glucose, BMI, Age) en categorías clínicas para probar la asociación categórica.

6.	Modelado Predictivo (Machine Learning):
o	Preprocesamiento: Los datos se escalaron usando StandardScaler.
o	Modelo: Se entrenó un modelo de Regresión Logística con Regularización L1 (Lasso), permitiendo que el modelo realice la selección de características automáticamente para manejar la multicolinealidad.
o	Evaluación: El rendimiento del modelo se evaluó usando la Matriz de Confusión, Accuracy, Precision, Recall y F1-Score.

 
Herramientas y Librerías Utilizadas
•	Python 3.x
•	Pandas: Para manipulación y limpieza de datos.
•	NumPy: Para cálculos numéricos y manejo de arrays.
•	Scikit-learn (sklearn):
o	KNNImputer: Para la imputación de datos.
o	StandardScaler: Para el escalado de características.
o	LogisticRegression: Para el modelado (con regularización L1/Lasso).
o	train_test_split: Para la división de datos.
o	metrics (confusion_matrix, classification_report): Para la evaluación del modelo.
•	SciPy (scipy.stats): Para todas las pruebas de inferencia estadística (Shapiro-Wilk, K-S, Spearman, Mann-Whitney U, Chi-Cuadrado, Levene).
•	Matplotlib & Seaborn: Para la visualización de datos (Pair plots, KDEs, Heatmaps).
•	Jupyter Notebook: Para el entorno de análisis interactivo.
