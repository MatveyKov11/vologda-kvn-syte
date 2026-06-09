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
                    <h4 class="ui header">
                        <div class="content">
                            Кто
                        </div>
                    </h4>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.subject" value="anon">
                        <label>Анонимные пользователи</label>
                    </div>
                    <div class="ui divider"/>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.subject" value="editor">
                        <label>Редакторы</label>
                    </div>
                    <div class="ui divider"/>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.subject" value="admin">
                        <label>Администраторы</label>
                    </div>
                </div>
                <div class="field">
                    <h4 class="ui header">
                        <div class="content">
                            Действие
                        </div>
                    </h4>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.action" value="Созд">
                        <label>Создание</label>
                    </div>
                    <div class="ui divider"/>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.action" value="Измен">
                        <label>Изменение</label>
                    </div>
                    <div class="ui divider"/>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.action" value="Удал">
                        <label>Удаление</label>
                    </div>
                </div>
                <div class="field">
                    <h4 class="ui header">
                        <div class="content">
                            Объект
                        </div>
                    </h4>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.object" value="post">
                        <label>Пост</label>
                    </div>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.object" value="table">
                        <label>Таблица</label>
                    </div>
                    <div class="ui divider"/>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.object" value="change">
                        <label>Стиль</label>
                    </div>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.object" value="user">
                        <label>Учетная запись</label>
                    </div>
                    <div class="ui divider"/>
                    <div class="ui checkbox">
                        <input type="checkbox" v-model="filter.object" value="comment">
                        <label>Комментарий</label>
                    </div>
                </div>
                <div class="field">
                    <h4 class="ui header">
                        <div class="content">
                            Дата
                        </div>
                    </h4>
                    <label>Начало периода</label>
                    <input type="datetime-local" v-model="filter.after">
                    <label>Конец периода</label>
                    <input type="datetime-local" v-model="filter.before">
                </div>
            </div>
        </div>
        <div class="ui divider"/>
        <button class="ui button" @click="filter = emptyFilter; $emit('clear')">
            <i class="x icon"></i> Очистить
        </button>
        <button class="ui primary button" @click="$emit('filter', filter)">
            <i class="check icon"></i> Применить фильтр
        </button>
    </div>
    {{ filter }}
</template>

<script setup>
import { ref } from 'vue';

const filter = ref({
    subject: [],
    action: [],
    object: [],
    before: 0,
    after: 0
})

const emptyFilter = {
    subject: [],
    action: [],
    object: [],
    before: 0,
    after: 0
}
</script>