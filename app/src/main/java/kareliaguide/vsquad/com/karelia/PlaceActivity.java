package kareliaguide.vsquad.com.karelia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class PlaceActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public TextView place_description;
    public FloatingActionButton icon_or_next;
    public ImageView background_photo;

    // БД для всех мест
    public String[][] Places_base = {{
            "Кижи",
            "Онежское озеро",
            "Валаамский монастырь",
            "Церковь Преображения Господня",
            "Ладожское озеро",
            "Рускеала Горный Парк",
            "Кивач",
            "Рускеальские водопады",
            "Воттоваара",
            "Памятник Петру I"
    },{
            "Ки́жи (также распространён вариант Кижи́, некоторыми филологами называемый «общепринятым»; карел. Kiži), или Ки́жский пого́ст — архитектурный ансамбль, расположенный на острове Кижи Онежского озера, состоящий из двух церквей и колокольни XVIII—XIX веков, окружённых единой оградой — реконструкцией традиционных оград погостов.\n" +
                    "\n" +
                    "2 октября 1945 года Постановлением ЦИК Карело-Финской ССР территория Кижского погоста была объявлена государственным заповедником.\n" +
                    "\n" +
                    "1 января 1966 года на базе архитектурного ансамбля Кижского погоста был основан Государственный историко-архитектурный музей «Кижи», куда помимо существующих на своих первоначальных местах построек было свезено большое количество часовен, домов и хозяйственных построек из Заонежья и других регионов Карелии.\n" +
                    "\n" +
                    "По одной из легенд, церковь Преображения Господня якобы была построена одним топором (изначально без гвоздей) плотником Нестором. Плотник выбросил топор в озеро, чтобы никто не смог повторить такую же величественную постройку.\n" +
                    "\n" +
                    "В 1990 году Кижский погост вошёл в Список Всемирного наследия ЮНЕСКО, в 1993 году указом Президента Российской Федерации архитектурное собрание музея под открытым небом включено в Государственный свод особо ценных объектов культурного наследия народов Российской Федерации.\n" +
                    "\n" +
                    "Все храмы, находящиеся на территории музея-заповедника «Кижи», входят в состав Спасо-Кижского Патриаршего подворья.",
            "Оне́жское о́зеро (Оне́го, вепс. Änine, карел. Oniegu, фин. Ääninen, Äänisjärvi) — озеро на северо-западе Европейской части Российской Федерации, второй по величине пресноводный водоём в Европе после Ладожского озера.\n" +
                    "\n" +
                    "Расположено на территории Республики Карелия, Ленинградской и Вологодской областей. Относится к бассейну Балтийского моря Атлантического океана.\n" +
                    "\n" +
                    "Около 80 % площади озера расположено в Республике Карелия, 20 % — в Ленинградской и Вологодской областях.\n" +
                    "\n" +
                    "Площадь озера без островов составляет 9690 км², а с островами — 9720 км²; объём водной массы — 285 км³; длина с юга на север — 245 км, наибольшая ширина — 91,6 км. Средняя глубина — 30 м, а максимальная — 127 м.\n" +
                    "\n" +
                    "Котловина озера расположена на стыке крупных геологических структур — Балтийского щита в северной части озера и Русской платформы в южной.\n" +
                    "\n" +
                    "На берегах Онежского озера расположены города Петрозаводск, Кондопога и Медвежьегорск. В Онежское озеро впадают около 50 рек, а вытекает только одна — Свирь.",
            "Валаа́мский Спа́со-Преображе́нский монастырь — ставропигиальный мужской монастырь Русской Православной Церкви, расположенный на островах Валаамского архипелага в Карелии.\n" +
                    "\n" +
                    "По преданию, во времена распространения христианства апостол Андрей Первозванный двигался на Север, проповедуя Евангелие. Пройдя Днепр и Волхов, ученик Христа вошёл в «бурные и вращающиеся воды озера Нево» и установил на «горах Валаамских» каменный крест. По одной из двух концепций возникновения монастыря спустя 900 лет двое иноков, Сергий и Герман, пришли «из восточных стран» (возможно, из Греции) и основали на одном из островов монашеское братство. Письменные источники («жития»), свидетельствующие о жизни и деяниях преподобных, считаются утраченными. Вторая концепция относит основание монастыря к X—XI векам. Она опирается на одну из редакций жития преподобного Авраамия Ростовского, содержащую упоминание о пребывании преподобного на Валааме в X веке, а также на ряд летописных упоминаний о переносе мощей преподобных Сергия и Германа с Валаама в Новгород в 1163 году.\n" +
                    "\n" +
                    "Относительно достоверная документальная история Валаамского монастыря начинается с XIV века. Валаамский монастырь упоминается в житии Савватия Соловецкого. В «Сказании о Валаамском монастыре» годом основания называется 1407 год.\n" +
                    "\n" +
                    "К началу XVI века на архипелаге жили около 600 монахов, но неоднократные нападения шведов привели к запустению благодатного острова.",
            "Церковь Преображения Господня — православный храм, памятник архитектуры федерального значения, расположенный на территории музея-заповедника «Кижи», входит в состав храмового комплекса Кижского погоста.\n" +
                    "\n" +
                    "Построена в 1714 году на месте одноимённой шатровой церкви, сгоревшей в 1694 году.\n" +
                    "\n" +
                    "Высота от основания до креста центральной главы — 37 м, размер в плане — 20,6×29 м.\n" +
                    "\n" +
                    "Относится к типу деревянных восьмериковых ярусных церквей. Основой композиции сооружения является восьмигранный сруб — «восьмерик» — с четырьмя двухступенчатыми прирубами, расположенными по сторонам света. Алтарный восточный прируб имеет в плане форму пятиугольника. С запада к основному срубу примыкает невысокий сруб трапезной (нартекса). На нижний восьмерик последовательно поставлены еще два восьмигранных сруба меньших размеров.\n" +
                    "\n" +
                    "Церковь увенчана двадцатью двумя главами, размещенными ярусами на кровлях прирубов и восьмериков, имеющих криволинейную форму кровли — так называемую «бочку». Форма и размеры глав меняются по ярусам, что придает своеобразный ритмический рисунок облику церкви. Трапезная перекрыта трехскатной крышей. Вход в церковь выполнен в форме двухвсходного крытого крыльца на консолях. Верхняя и нижняя площадки крыльца перекрыты двускатными крышами на резных столбах. Верхние восьмерики опираются на перекрещивающиеся балки нижележащих восьмериков — «переходные четверики» — и раскреплены бревенчатыми подкосами.\n" +
                    "\n" +
                    "Основа интерьера церкви — четырёхъярусный иконостас, включающий 102 иконы.\n" +
                    "\n" +
                    "В 1990 году храм включён в список всемирного природного и культурного наследия ЮНЕСКО.\n" +
                    "\n" +
                    "Среди исследователей деревянного зодчества существует мнение, что прообразами кижской Преображенской церкви являются Церковь Покрова Пресвятой Богородицы располагавшаяся в Вытегорском уезде и Храм Покрова Божией Матери расположенный в Архангельской области.",
            "Ла́дожское о́зеро (также Ла́дога; в древности — Не́во) — озеро в Республике Карелия (северный и восточный берег) и Ленинградской области (западный, южный и юго-восточный берег), крупнейшее пресноводное озеро в Европе.\n" +
                    "\n" +
                    "Относится к бассейну Балтийского моря Атлантического океана. Площадь озера без островов составляет от 17,9 тысяч км² (с островами 18,3 тысяч км²); объём водной массы — 838 км³; длина с юга на север — 219 км, наибольшая ширина — 125 км. Высота над уровнем моря — 4,84 м. Глубина изменяется неравномерно: в северной части она колеблется от 70 до 230 м, в южной — от 20 до 70 м. На берегах Ладожского озера расположены города Приозерск, Новая Ладога, Шлиссельбург в Ленинградской области, Сортавала, Питкяранта, Лахденпохья в Республике Карелия. В Ладожское озеро впадают не менее 40 рек и крупных ручьёв, а вытекает одна — река Нева. В южной половине озера — три крупных залива: Свирская, Волховская и Шлиссельбургская губы.\n" +
                    "\n" +
                    "Приладожье:\n" +
                    "\n" +
                    "Северное Приладожье — южная Карелия;\n" +
                    "Восточное Приладожье — Олонецкий район Карелии;\n" +
                    "Южное Приладожье — Кировский и Волховский районы Ленинградской области;\n" +
                    "Западное Приладожье — Карельский перешеек.",
            "«Горный парк Рускеала» был создан на средства туристической фирмы «Колмас Карелия» и открыт для массового посещения 19 мая 2005 г.\n" +
                    "Сейчас «Горный парк Рускеала» уже известен и завоевал заслуженную популярность. Его посещают десятки тысяч туристов в год.\n" +
                    "\n" +
                    "Создание памятника индустриальной культуры «Мраморные ломки Рускеала XVII – нач. ХХ вв.» в виде горного парка – положительный и нечасто встречающийся в современной России пример вложения частных средств в объект культурного наследия. Здесь удалось создать очень редкий симбиоз природной достопримечательности и натурного музея горного дела прошлых веков. Возник небывалый, теперь уже именно природный ансамбль, прекрасный в любое время года.\n" +
                    "Вдоль левого берега р.Тохмайоки в процессе добычи мрамора образовались три карьера, соединенные штольнями. Добыча камня прекратилась и старинные заброшенные рускеальские каменоломни превратились в красивые горные озёра - беломраморные чаши, наполненные чистейшей голубовато-зелёной водой. Давно бездействующие шахты и штольни стали похожи на таинственные пещеры и гроты.\n" +
                    "\n" +
                    "\n" +
                    "Основой достопримечательностью Горного парка является Мраморный каньон – памятник индустриальной культуры (горного дела) конца XVIII - начала XX в.в., официально включенный в список культурного наследия России в 1998 г. Подобного памятника, представляющего собой рукотворную «чашу» в сплошном массиве мраморов, прорезанного системой шахт, штолен и штреков, в Европе больше нет. Отсюда были получены блоки для облицовки многих архитектурных творений Санкт-Петербурга, в том числе и величественного Исаакиевского собора. Рускеальский мрамор цвета белых ночей, с зеленоватыми, похожими на северное сияние всполохами добывался для украшения самых разных архитектурных сооружений. Серовато-зеленым и светло-серым мрамором Рускеалы украшены залы ленинградских станций метро \"Приморская\" и \"Ладожская\")",
            "Кива́ч (карел. Kivačču, фин. Kivatsu) — водопад на реке Суна в Республике Карелия.\n" +
                    "\n" +
                    "Название водопада происходит, видимо, от финского «kiivas», что означает «мощный, стремительный».\n" +
                    "\n" +
                    "Высота общего падения водопада 10,7 м на участке протяжённостью 170 м. Высота отвесного падения — 8 м. Уступ водопада образован выходами диабаза.\n" +
                    "\n" +
                    "Водопад разделён скалой на два потока: главный (правый) и второстепенный (левый). Главный поток низвергается по четырём уступам, второстепенный разбит на несколько струй, направленных под прямым углом к главному потоку.\n" +
                    "\n" +
                    "Водопад является экскурсионным объектом в пределах заповедника «Кивач», площадь которого более 10 тысяч га. У водопада располагаются Музей природы и дендрарий.",
            "Рускеа́льские водопа́ды — четыре равнинных водопада в Сортавальском районе Карелии рядом с посёлком Рускеала на реке Тохмайоки. Высота водопадов колеблется в пределах 3-4 метров.\n" +
                    "\n" +
                    "\n" +
                    "Рускеальские водопады, верхний водопад\n" +
                    "Водопады известны туристам и экстремалам, преодолевающим их на каяках.\n" +
                    "\n" +
                    "Эти водопады получили известность благодаря советскому фильму «А зори здесь тихие» (1972 года).\n" +
                    "\n" +
                    "Также здесь снимали фильм «Тёмный мир». Для съёмок прямо на водопаде был сооружён муляж рубленной избы, который так и остался после съёмок.",
            "Во́ттова́ара — скальный массив Западно-Карельской возвышенности на территории Суккозерского сельского поселения в юго-восточной части Муезерского района в центральной части Республики Карелия.\n" +
                    "\n" +
                    "На плато находится множество камней, абсолютное большинство которых — это окатанные валуны. В некоторых случаях крупные валуны находятся в оригинальном положении. Впервые об этих каменных скоплениях как об искусственных сооружениях сообщил в конце 1970-х годов краевед из посёлка Суккозеро С. М. Симонян. В начале 1990-х на горе провели обследования археологи М. М. Шахнович и И. С. Манюхин, которые сделали вывод об их культовом предназначении и принадлежности культуре древних саамов. Вышедший вслед за этим ряд публикаций в прессе вызвал интерес к Воттовааре, причём не только со стороны археологов, но и представителей мистических и квазинаучных течений.\n" +
                    "\n" +
                    "Между тем, в научных кругах мнение о рукотворности рассматриваемых групп камней не получило широкого распространения. Например, старший научный сотрудник Сектора археологии Института языка, литературы и истории Карельского научного центра Российской академии наук М. Г. Косменко и Н. В. Лобанова считают, что их можно разделить на каменные скопления естественного сложения, а также новоделы последнего времени, сооружённые для мистификации или просто на память о посещении горы; при этом исследователи указывают, что синхронные поселения каменного века в окрестностях горы, или какие-либо другие материальные следы «древнего саамского населения» в настоящее время не известны.\n" +
                    "\n" +
                    "В августе 2011 года постановлением правительства Республики Карелия комплекс горы Воттоваара был объявлен ландшафтным памятником природы. Охраняемая территория занимает площадь более полутора тысяч гектаров: в неё входит сама гора и прилегающая к ней местность.",
            "Памятник императору Петру Великому, основателю Петрозаводска (карел. Pietaren Šuuren muistopačas) — памятник первому российскому императору Петру I работы скульптора Ивана Николаевича Шредера и архитектора Ипполита Антоновича Монигетти в городе Петрозаводске.\n" +
                    "\n" +
                    "Памятник заложен 30 мая 1872 года в честь 200-летия со дня рождения Петра I, а открыт 29 июня 1873 года в честь 100-летия со дня открытия Александровского завода. Является объектом культурного наследия (памятник монументального искусства) федерального значения (1960. Инициатор создания памятника — губернатор Олонецкой губернии Григорий Григорьевич Григорьев.\n" +
                    "\n" +
                    "Впервые идея установить памятник Петру I возникла в 1850 году. Губернатор Николай Эрастович Писарев вознамерился на месте бывшего царского дворца установить памятник Петру I как основателю города. Памятник, по мнению губернатора, должен быть «простой архитектуры с приличной надписью». Министр внутренних дел граф Перовский выразил мнение, что проект не отвечает «высокому назначению», и предложил найти средства «для выполнения, хотя простого, но вполне изящного и художественного монумента».\n" +
                    "\n" +
                    "Следующая идея создания памятника Петру I принадлежала олонецкому губернатору Григорию Григорьевичу Григорьеву. Вице-адмиралу Посьету 24 апреля 1871 года он пишет: «… губернатор вошёл с представлением к министру внутренних дел о введении в Петрозаводске памятника Петру I на счёт казны и полагал, что предстоящее 200-летие монарха 30 мая 1872 года есть самый лучший и соответствующий момент по историческому значению для открытия памятника». Также губернатор предложил место для установки памятника: «… самым выгодным пунктом для памятника представляется Круглая площадь между зданием Присутственных мест и Губернаторским домом… Вид с этой площади к юго-востоку открыт в далёкое пространство, перед нею расположен Александровский пушечный завод, а к востоку видны Петровский сад и городской собор с Петропавловской церковью»."
    }};

    // БД для категорий
    public String[][] Category_trees = {{
            // Titles
            ""
    },{
            // Descriptions
            ""
    }};

    public String[][] Category_culture = {{
            // Titles
            ""
    },{
            // Descriptions
            ""
    }};

    public String[][] Category_active = {{
            // Titles
            ""
    },{
            // Descriptions
            ""
    }};

    public String[][] Category_food = {{
            // Titles
            ""
    },{
            // Descriptions
            ""
    }};

    public String[][] Category_popular = {{
            // Titles
            ""
    },{ // Descriptions
            ""
    }};

    // Nearby - ???


    // БД долготы и широты для всех мест; Потом изменить по номерам
    public double[] Places_latitude = {
            62.0844,
            61.6057,
            61.389167,
            62.0661,
            60.7954,
            61.9446486,
            62.2628,
            61.9095,
            63.0697,
            61.7903
    };

    public double[] Places_longitude = {
            35.2191,
            35.9583,
            30.945,
            35.2412,
            31.9908,
            30.5128264,
            33.9775,
            30.629,
            32.6254,
            34.3897
    };

    public int place_num;
    public int shown_place = 0;
    public double lat;
    public double lon;

    public ArrayList<Double> Locations_list_lat;
    public ArrayList<Double> Locations_list_lon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        place_description = (TextView) findViewById(R.id.place_description);
        icon_or_next = (FloatingActionButton) findViewById(R.id.icon_or_next);
        background_photo = (ImageView) findViewById(R.id.main_backdrop);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Bundle getData = getIntent().getExtras();

        if (getData != null) {
            place_num = getData.getInt("place_num"); // Получаем номер места, необходимого для подгрузки
            lat = getData.getDouble("latitude"); // Получаем широту места
            lon = getData.getDouble("longitude"); // Получаем долготу места
            Locations_list_lat = (ArrayList<Double>) getData.getSerializable(""); // Получаем список уже доабвлененных локаций, долгота
            Locations_list_lon = (ArrayList<Double>) getData.getSerializable(""); // Получаем список уже доабвлененных локаций, широта

        }

        Locations_list_lat = new ArrayList<>();
        Locations_list_lon = new ArrayList<>();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Locations_list_lat != null) {
                    if (Locations_list_lon.contains(lon) && Locations_list_lat.contains(lat)) {
                        Snackbar.make(view, "Данная локация уже есть в Вашем списке", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    } else {
                        Locations_list_lat.add(lat);
                        Locations_list_lon.add(lon);
                        Snackbar.make(view, "Локация добавлена в Ваш маршрут", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                } else {
                    Locations_list_lat.add(lat);
                    Locations_list_lon.add(lon);
                    Snackbar.make(view, "Локация добавлена в Ваш маршрут", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        /*
        [0;n]: номер места
        {-1}: место не указано
        [-7;-2]: номер категории для отображения

        {-2}: активный отдых
        {-3}: культурный отдых
        {-4}: природа
        {-5}: еда, гурман
        */

        switch (place_num) {
            // Определение единичных мест
            case 0:
                setTitle(Places_base[0][0]);
                place_description.setText(Places_base[1][0]);
                background_photo.setImageResource(R.drawable.kizhi);
                icon_or_next.setImageResource(R.drawable.active);
                break;
            case 1:
                setTitle(Places_base[0][1]);
                place_description.setText(Places_base[1][1]);
                background_photo.setImageResource(R.drawable.onezhskoe_ozero);
                break;
            case 2:
                setTitle(Places_base[0][2]);
                place_description.setText(Places_base[1][2]);
                background_photo.setImageResource(R.drawable.monastir);
                break;
            case 3:
                setTitle(Places_base[0][3]);
                place_description.setText(Places_base[1][3]);
                background_photo.setImageResource(R.drawable.cerkovnakizhah);
                break;
            case 4:
                setTitle(Places_base[0][4]);
                place_description.setText(Places_base[1][4]);
                background_photo.setImageResource(R.drawable.ladojskoe);
                break;
            case 5:
                setTitle(Places_base[0][5]);
                place_description.setText(Places_base[1][5]);
                background_photo.setImageResource(R.drawable.ruskeala);
                break;
            case 6:
                setTitle(Places_base[0][6]);
                place_description.setText(Places_base[1][6]);
                background_photo.setImageResource(R.drawable.kivach);
                break;
            case 7:
                setTitle(Places_base[0][7]);
                place_description.setText(Places_base[1][7]);
                background_photo.setImageResource(R.drawable.vodopadi);
                break;
            case 8:
                setTitle(Places_base[0][8]);
                place_description.setText(Places_base[1][8]);
                background_photo.setImageResource(R.drawable.vottavara);
                break;
            case 9:
                setTitle(Places_base[0][9]);
                place_description.setText(Places_base[1][9]);
                background_photo.setImageResource(R.drawable.petr_first);
                break;

            // Определение по категориям
            case -2:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle(Category_active[shown_place%Category_active.length][shown_place+1%Category_active.length]);
                place_description.setText(Category_active[shown_place%Category_active.length][shown_place+1%Category_active.length]);
                background_photo.setImageResource(R.drawable.karelia);
            case -3:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle("");
                place_description.setText("");
            case -4:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle("");
                place_description.setText("");
            case -5:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle("");
                place_description.setText("");
            case -6:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle("");
                place_description.setText("");
            case -7:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle("");
                place_description.setText("");

            // Место не указано
            case -1:
                // обработка
        }
    }

    public void ic_next (View view){
        if (place_num <= -2 && place_num >= -7){
            shown_place++;
            setTitle(Category_active[shown_place%Category_active.length][shown_place+1%Category_active.length]);
            place_description.setText(Category_active[shown_place%Category_active.length][shown_place+1%Category_active.length]);
            background_photo.setImageResource(R.drawable.karelia);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.place, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
