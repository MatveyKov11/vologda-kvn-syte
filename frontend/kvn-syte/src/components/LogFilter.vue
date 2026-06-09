<template>
    <div class="ui segment">
        <h3 class="ui header">
            <div class="content">
                Фильтр логов
            </div>
        </h3>
        <div class="ui form">
            <div class="four fields">
                <div class="field">
                    <label>Кто</label>
                    <div class="ui checkbox">
                        <input type="checkbox">
                        <label>Анонимные пользователи</label>
                        <input type="checkbox">
                        <label>Редакторы</label>
                        <input type="checkbox">
                        <label>Администраторы</label>
                    </div>
                </div>
                <div class="field">
                    <label>Действие</label>
                    <div class="ui checkbox">
                        <input type="checkbox">
                        <label>Создание</label>
                        <input type="checkbox">
                        <label>Удаление</label>
                        <input type="checkbox">
                        <label>Изменение</label>
                    </div>
                </div>
                <div class="field">
                    <label>Объект</label>
                    <div class="ui checkbox">
                        <input type="checkbox">
                        <label>Учетная запись</label>
                        <input type="checkbox">
                        <label>Таблица</label>
                        <input type="checkbox">
                        <label>Пост</label>
                        <input type="checkbox">
                        <label>Стиль</label>
                        <input type="checkbox">
                        <label>Комментарий</label>
                    </div>
                </div>
                <div class="field">
                    <label>Время</label>
                    <label>Начало периода</label>
                    <input type="date">
                    <label>Конец периода</label>
                    <input type="date">
                </div>
            </div>
        </div>
        <div class="ui divider"/>
        <button class="ui button">
            <i class="x icon"></i> Очистить
        </button>
        <button class="ui primary button">
            <i class="check icon"></i> Применить фильтр
        </button>
    </div>
</template>